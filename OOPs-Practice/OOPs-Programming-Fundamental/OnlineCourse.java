class Course {
    // Instance Variables
    String courseName;
    int duration; // in months
    double fee;

    // Class Variable
    static String instituteName = "BridgeLabz";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance Method
    void displayCourseDetails() {
        System.out.println("Institute Name : " + instituteName);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Duration       : " + duration + " months");
        System.out.println("Fee            : ₹" + fee);
        System.out.println();
    }

    // Class Method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class OnlineCourse {
    public static void main(String[] args) {

        Course c1 = new Course("Java Full Stack", 6, 50000);
        Course c2 = new Course("Data Science", 8, 70000);

        System.out.println("Before Updating Institute Name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name for all courses
        Course.updateInstituteName("Tech Academy");

        System.out.println("After Updating Institute Name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}