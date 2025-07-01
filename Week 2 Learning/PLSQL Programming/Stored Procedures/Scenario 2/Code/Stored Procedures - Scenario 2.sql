-- Drop tables if they exist (cascade constraints)
BEGIN
   BEGIN EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END;
END;
/
-- Create Employees table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);
-- Insert sample data into Employees
INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (3, 'Carol White', 'Analyst', 50000, 'HR', TO_DATE('2019-01-10', 'YYYY-MM-DD'));
COMMIT;
-- Create the stored procedure to update employee bonuses
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) IS
    emp_count NUMBER;
BEGIN
    -- Check if department exists
    SELECT COUNT(*) INTO emp_count FROM Employees WHERE Department = p_department;
    IF emp_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department "' || p_department || '". No updates made.');
        RETURN;
    END IF;
    -- Update salaries by adding bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salaries updated with ' || p_bonus_percent || '% bonus for department "' || p_department || '".');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/

-- Test bonus update for HR department
BEGIN
    UpdateEmployeeBonus('HR', 10);
END;
/

-- Test bonus update for a non-existent department
BEGIN
    UpdateEmployeeBonus('Marketing', 5);
END;
/

-- Check updated salaries
SELECT EmployeeID, Name, Department, Salary FROM Employees ORDER BY EmployeeID;