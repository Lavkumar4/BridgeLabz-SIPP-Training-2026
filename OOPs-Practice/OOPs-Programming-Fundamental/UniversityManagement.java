class Student {

    // Public member
    public int rollNumber;

    // Protected member
    protected String name;

    // Private member
    private double cgpa;

    // Constructor
    Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // Public getter
    public double getCGPA() {
        return cgpa;
    }

    // Public setter
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }
}

// Subclass
class PostgraduateStudent extends Student {

    PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }

    void displayDetails() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name); // protected member
        System.out.println("CGPA        : " + getCGPA()); // private accessed via getter
    }
}

public class UniversityManagement {
    public static void main(String[] args) {

        PostgraduateStudent student =
                new PostgraduateStudent(101, "Lav", 8.7);

        System.out.println("Before Updating CGPA:");
        student.displayDetails();

        // Modify private CGPA using setter
        student.setCGPA(9.1);

        System.out.println("\nAfter Updating CGPA:");
        student.displayDetails();
    }
}