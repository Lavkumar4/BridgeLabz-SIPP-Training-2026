import java.util.*;

class AttendanceTracker {
    // Key: Subject Name, Value: Set of student names (unique attendance)
    private HashMap<String, HashSet<String>> attendanceMap = new HashMap<>();

    // 1. Mark Attendance
    public void markAttendance(String subject, String studentName) {
        // अगर subject पहली बार आ रहा है, तो नया HashSet बनाएं
        attendanceMap.putIfAbsent(subject, new HashSet<>());

        // HashSet में add करने से डुप्लीकेट अपने आप रुक जाते हैं
        boolean isAdded = attendanceMap.get(subject).add(studentName);

        if (isAdded) {
            System.out.println("✅ Attendance marked for " + studentName + " in " + subject);
        } else {
            System.out.println("⚠️ " + studentName + " is already marked present in " + subject);
        }
    }

    // 2 & 3. Display Attendance per Subject
    public void displayAttendance() {
        System.out.println("\n--- Attendance Records ---");
        for (String subject : attendanceMap.keySet()) {
            HashSet<String> students = attendanceMap.get(subject);
            System.out.println("Subject: " + subject);
            System.out.println("Students Present: " + students);
            System.out.println("Total count: " + students.size());
            System.out.println("--------------------------");
        }
    }
}

public class ClassroomSystem {
    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();

        // Attendance marking
        tracker.markAttendance("Math", "Rahul");
        tracker.markAttendance("Math", "Amit");
        tracker.markAttendance("Math", "Rahul"); // Duplicate attempt
        tracker.markAttendance("Physics", "Rahul");
        tracker.markAttendance("Physics", "Priya");

        // Display everything
        tracker.displayAttendance();
    }
}