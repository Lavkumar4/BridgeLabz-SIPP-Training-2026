class Employee {

    // Public member
    public int employeeID;

    // Protected member
    protected String department;

    // Private member
    private double salary;

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Public method to access salary
    public double getSalary() {
        return salary;
    }
}

// Subclass
class Manager extends Employee {

    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    void displayDetails() {
        System.out.println("Employee ID : " + employeeID);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : ₹" + getSalary());
    }
}

public class EmployeeRecord {
    public static void main(String[] args) {

        Manager m = new Manager(1001, "IT", 75000);

        System.out.println("Before Salary Update:");
        m.displayDetails();

        // Modify private salary using public method
        m.setSalary(85000);

        System.out.println("\nAfter Salary Update:");
        m.displayDetails();
    }
}