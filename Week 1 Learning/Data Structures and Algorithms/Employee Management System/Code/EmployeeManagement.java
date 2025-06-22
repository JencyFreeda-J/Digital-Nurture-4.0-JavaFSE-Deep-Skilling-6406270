// Exercise 4: Employee Management System

// Step 1: Understanding Array Representation
// Arrays are stored in contiguous memory locations, allowing O(1) access by index.
// Advantages: Fast access, fixed-size memory allocation. Limitations: Size is fixed, insertions/deletions can be costly.

class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    public boolean addEmployee(Employee e) {
        if (size >= employees.length)
            return false; // Array full
        employees[size++] = e;
        return true;
    }

    // Search employee by ID
    public Employee searchEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(id)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse employees
    public void displayEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    // Delete employee by ID
    public boolean deleteEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(id)) {
                // Shift left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);

        // Add Employees
        em.addEmployee(new Employee("E001", "Alice", "Manager", 80000));
        em.addEmployee(new Employee("E002", "Bob", "Engineer", 60000));
        em.addEmployee(new Employee("E003", "Charlie", "Analyst", 50000));

        // Display all employees
        System.out.println("--- All Employees ---");
        em.displayEmployees();

        // Search for an employee
        System.out.println("\n--- Search Employee E002 ---");
        Employee found = em.searchEmployee("E002");
        System.out.println(found != null ? found : "Employee not found");

        // Delete an employee
        System.out.println("\n--- Delete Employee E001 ---");
        boolean deleted = em.deleteEmployee("E001");
        System.out.println(deleted ? "Employee deleted successfully." : "Employee not found.");

        // Display all employees after deletion
        System.out.println("\n--- All Employees After Deletion ---");
        em.displayEmployees();
    }
}