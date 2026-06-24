// Abstract Class
abstract class Employee {

    // Private Fields (Encapsulation)
    private int employeeId;
    private String employeeName;

    // Constructor
    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // Abstract Method (Abstraction)
    public abstract double calculateSalary();

    // Concrete Method
    public void displayEmployeeInfo() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
    }
}

// FullTimeEmployee Class
class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(int employeeId,
                            String employeeName,
                            double monthlySalary) {
        super(employeeId, employeeName);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// PartTimeEmployee Class
class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId,
                            String employeeName,
                            int hoursWorked,
                            double hourlyRate) {
        super(employeeId, employeeName);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main Class
public class PayrollSystem {

    public static void main(String[] args) {

        FullTimeEmployee emp1 =
                new FullTimeEmployee(101, "Lav Kumar", 50000);

        PartTimeEmployee emp2 =
                new PartTimeEmployee(102, "Rahul Sharma", 80, 500);

        System.out.println("===== Full Time Employee =====");
        emp1.displayEmployeeInfo();
        System.out.println("Salary : ₹" + emp1.calculateSalary());

        System.out.println();

        System.out.println("===== Part Time Employee =====");
        emp2.displayEmployeeInfo();
        System.out.println("Salary : ₹" + emp2.calculateSalary());
    }
}