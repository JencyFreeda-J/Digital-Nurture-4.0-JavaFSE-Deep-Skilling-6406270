-- Step 1: Delete existing data (if tables exist)
BEGIN
   BEGIN EXECUTE IMMEDIATE 'DELETE FROM Transactions'; EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DELETE FROM Accounts';     EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DELETE FROM Loans';        EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DELETE FROM Employees';    EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DELETE FROM Customers';    EXCEPTION WHEN OTHERS THEN NULL; END;
   COMMIT;
END;
/

-- Step 2: CREATE TABLES (safe to run if they don't exist)
BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE Customers (
       CustomerID NUMBER PRIMARY KEY,
       Name VARCHAR2(100),
       DOB DATE,
       Balance NUMBER,
       LastModified DATE,
       IsVIP CHAR(1) DEFAULT ''N''
   )';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE Accounts (
       AccountID NUMBER PRIMARY KEY,
       CustomerID NUMBER,
       AccountType VARCHAR2(20),
       Balance NUMBER,
       LastModified DATE,
       FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
   )';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE Transactions (
       TransactionID NUMBER PRIMARY KEY,
       AccountID NUMBER,
       TransactionDate DATE,
       Amount NUMBER,
       TransactionType VARCHAR2(10),
       FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
   )';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE Loans (
       LoanID NUMBER PRIMARY KEY,
       CustomerID NUMBER,
       LoanAmount NUMBER,
       InterestRate NUMBER,
       StartDate DATE,
       EndDate DATE,
       FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
   )';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE Employees (
       EmployeeID NUMBER PRIMARY KEY,
       Name VARCHAR2(100),
       Position VARCHAR2(50),
       Salary NUMBER,
       Department VARCHAR2(50),
       HireDate DATE
   )';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- Step 3: INSERT SAMPLE DATA SAFELY USING MERGE

-- Customers
MERGE INTO Customers c USING (SELECT 1 AS CustomerID FROM dual) src
ON (c.CustomerID = src.CustomerID)
WHEN NOT MATCHED THEN INSERT (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 1000, SYSDATE, 'N');

MERGE INTO Customers c USING (SELECT 2 AS CustomerID FROM dual) src
ON (c.CustomerID = src.CustomerID)
WHEN NOT MATCHED THEN INSERT (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 15000, SYSDATE, 'N');

MERGE INTO Customers c USING (SELECT 3 AS CustomerID FROM dual) src
ON (c.CustomerID = src.CustomerID)
WHEN NOT MATCHED THEN INSERT (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (3, 'Paul Senior', TO_DATE('1940-02-10', 'YYYY-MM-DD'), 800, SYSDATE, 'N');

-- Accounts
MERGE INTO Accounts a USING (SELECT 1 AS AccountID FROM dual) src
ON (a.AccountID = src.AccountID)
WHEN NOT MATCHED THEN INSERT (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

MERGE INTO Accounts a USING (SELECT 2 AS AccountID FROM dual) src
ON (a.AccountID = src.AccountID)
WHEN NOT MATCHED THEN INSERT (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

-- Transactions
MERGE INTO Transactions t USING (SELECT 1 AS TransactionID FROM dual) src
ON (t.TransactionID = src.TransactionID)
WHEN NOT MATCHED THEN INSERT (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

MERGE INTO Transactions t USING (SELECT 2 AS TransactionID FROM dual) src
ON (t.TransactionID = src.TransactionID)
WHEN NOT MATCHED THEN INSERT (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

-- Loans
MERGE INTO Loans l USING (SELECT 1 AS LoanID FROM dual) src
ON (l.LoanID = src.LoanID)
WHEN NOT MATCHED THEN INSERT (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

MERGE INTO Loans l USING (SELECT 2 AS LoanID FROM dual) src
ON (l.LoanID = src.LoanID)
WHEN NOT MATCHED THEN INSERT (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 3000, 6, SYSDATE, SYSDATE + 20);

-- Employees
MERGE INTO Employees e USING (SELECT 1 AS EmployeeID FROM dual) src
ON (e.EmployeeID = src.EmployeeID)
WHEN NOT MATCHED THEN INSERT (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

MERGE INTO Employees e USING (SELECT 2 AS EmployeeID FROM dual) src
ON (e.EmployeeID = src.EmployeeID)
WHEN NOT MATCHED THEN INSERT (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));
/

BEGIN
   FOR cust IN (
      SELECT CustomerID, Balance
      FROM Customers
   ) LOOP
      IF cust.Balance > 10000 THEN
         UPDATE Customers
         SET IsVIP = 'Y'
         WHERE CustomerID = cust.CustomerID;
      END IF;
   END LOOP;
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('VIP status updated for eligible customers.');
END;
/

SELECT * FROM Customers;