import java.util.Arrays;

public class AttendanceRanking {

    // A helper class to bundle Employee ID and Attendance together
    static class Employee implements Comparable<Employee> {
        int id;
        int attendance;

        public Employee(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }

        // Custom sorting logic
        @Override
        public int compareTo(Employee other) {
            // 1. Sort by attendance in descending order
            if (this.attendance != other.attendance) {
                return Integer.compare(other.attendance, this.attendance);
            }
            // 2. If attendance is a tie, sort by ID in ascending order
            return Integer.compare(this.id, other.id);
        }
    }

    public static int[] getTopKEmployees(int[] employeeIds, int[] attendance, int K) {
        int n = employeeIds.length;
        Employee[] employees = new Employee[n];

        // Step 1: Pair up employee elements into an array of Employee objects
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee(employeeIds[i], attendance[i]);
        }

        // Step 2: Sort based on our custom rules using TimSort (O(N log N))
        Arrays.sort(employees);

        // Step 3: Extract the top K employee IDs
        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            result[i] = employees[i].id;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int K = 3;

        int[] topK = getTopKEmployees(employeeIds, attendance, K);
        
        // Output should be: [103, 101, 104]
        System.out.println("Top " + K + " Employees: " + Arrays.toString(topK));
    }
}