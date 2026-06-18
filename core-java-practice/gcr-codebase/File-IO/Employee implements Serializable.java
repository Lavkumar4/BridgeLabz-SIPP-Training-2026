import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int employeeId;
    String name;
    String department;
    double salary;

    public Employee(int employeeId, String name,
                    String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + salary);
    }
}