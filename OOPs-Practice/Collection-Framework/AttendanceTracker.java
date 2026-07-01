import java.util.*;

public class AttendanceTracker {
    // HashMap to store Subject Name and a list of students present
    private Map<String, ArrayList<String>> attendanceMap = new HashMap<>();

    // Method to mark attendance
    public void markAttendance(String subject, String studentName) {
        // Initialize the list for the subject if it doesn't exist
        attendanceMap.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendanceMap.get(subject);

        // Check for duplicates before adding
        if (!students.contains(studentName)) {
            students.add(studentName);
            System.out.println("Attendance marked for " + studentName + " in " + subject);
        } else {
            System.out.println("Duplicate entry: " + studentName + " is already marked for " + subject);
        }
    }

    // Method to display attendance and total count
    public void displayAttendance() {
        System.out.println("\n--- Current Attendance Records ---");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            String subject = entry.getKey();
            ArrayList<String> students = entry.getValue();

            System.out.println("Subject: " + subject);
            System.out.println("Students: " + students);
            System.out.println("Total present: " + students.size());
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();

        // Marking attendance
        tracker.markAttendance("Mathematics", "Alice");
        tracker.markAttendance("Mathematics", "Bob");
        tracker.markAttendance("Mathematics", "Alice"); // Duplicate test
        tracker.markAttendance("Physics", "Charlie");
        tracker.markAttendance("Physics", "Bob");

        // Displaying results
        tracker.displayAttendance();
    }
}