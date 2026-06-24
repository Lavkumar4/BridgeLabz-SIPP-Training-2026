class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [Name=" + name + ", Age=" + age + "]";
    }
}

class Student extends Person {
    final int studentId; // final variable
    double gpa;

    Student(String name, int age, int studentId, double gpa) {
        super(name, age); // call Person constructor
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Student [ID=" + studentId +
                ", GPA=" + gpa + "]";
    }
}

class GradStudent extends Student {
    String thesis;

    GradStudent(String name, int age, int studentId,
                double gpa, String thesis) {
        super(name, age, studentId, gpa); // call Student constructor
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", GradStudent [Thesis=" + thesis + "]";
    }
}

public class UniversityDemo {
    public static void main(String[] args) {

        GradStudent gs = new GradStudent(
                "Lav Kumar",
                22,
                101,
                8.9,
                "Artificial Intelligence"
        );

        System.out.println(gs);

        // Demonstrating IS-A relationship
        Student s = gs;   // GradStudent IS-A Student
        Person p = gs;    // GradStudent IS-A Person

        System.out.println("\nIS-A Relationship:");
        System.out.println("GradStudent IS-A Student: " + (s instanceof Student));
        System.out.println("GradStudent IS-A Person: " + (p instanceof Person));
    }
}