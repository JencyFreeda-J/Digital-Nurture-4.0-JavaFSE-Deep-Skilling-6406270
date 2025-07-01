-- Drop tables if they exist, cascade constraints for safety
BEGIN
   BEGIN EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END;
END;
/
-- Create Customers table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);
-- Create Accounts table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    CONSTRAINT fk_customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
-- Create Transactions table
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    CONSTRAINT fk_account FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
-- Insert sample data into Customers
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);
COMMIT;
-- Insert sample data into Accounts
INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);
COMMIT;
-- Create the stored procedure for fund transfer
CREATE OR REPLACE PROCEDURE TransferFunds (
    from_acc_id IN NUMBER,
    to_acc_id IN NUMBER,
    amt IN NUMBER
) IS
    insufficient_funds EXCEPTION;
    from_balance NUMBER;
    txn_id NUMBER;
BEGIN
    -- Lock source account row
    SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_acc_id FOR UPDATE;
    -- Check sufficient funds
    IF from_balance < amt THEN
        RAISE insufficient_funds;
    END IF;
    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - amt,
        LastModified = SYSDATE
    WHERE AccountID = from_acc_id;
    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + amt,
        LastModified = SYSDATE
    WHERE AccountID = to_acc_id;
    -- Generate next transaction ID safely
    SELECT NVL(MAX(TransactionID), 0) + 1 INTO txn_id FROM Transactions;
    -- Insert debit transaction
    INSERT INTO Transactions VALUES (txn_id, from_acc_id, SYSDATE, amt, 'Debit');
    -- Insert credit transaction
    INSERT INTO Transactions VALUES (txn_id + 1, to_acc_id, SYSDATE, amt, 'Credit');
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || amt || ' from Account ' || from_acc_id || ' to Account ' || to_acc_id);
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds in Account ' || from_acc_id);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

-- Test successful transfer
BEGIN
    TransferFunds(1, 2, 300);
END;
/

-- Test failure due to insufficient funds
BEGIN
    TransferFunds(1, 2, 2000);
END;
/

-- Check balances
SELECT * FROM Accounts ORDER BY AccountID;

-- Check transactions
SELECT * FROM Transactions ORDER BY TransactionID;