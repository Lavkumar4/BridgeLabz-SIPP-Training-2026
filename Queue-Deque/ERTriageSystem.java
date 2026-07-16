import java.util.*;

public class ERTriageSystem {

    static class Patient {
        int priority; // 1 = most critical/urgent, 5 = least urgent
        String name;
        long arrivalOrder; // tie-breaker, see note below

        Patient(int priority, String name, long arrivalOrder) {
            this.priority = priority;
            this.name = name;
            this.arrivalOrder = arrivalOrder;
        }

        @Override
        public String toString() {
            return name + " (priority=" + priority + ")";
        }
    }

    private final PriorityQueue<Patient> triageQueue =
        new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return a.priority - b.priority; // lower number = more urgent = comes first
            }
            return Long.compare(a.arrivalOrder, b.arrivalOrder); // tie-break: earlier arrival first
        });

    private long arrivalCounter = 0;

    /** A new patient checks in with a given triage priority. */
    public void admitPatient(int priority, String name) {
        triageQueue.offer(new Patient(priority, name, arrivalCounter++));
    }

    /** The next most urgent patient is called in for treatment. */
    public Patient callNextPatient() {
        if (triageQueue.isEmpty()) {
            throw new NoSuchElementException("No patients waiting");
        }
        return triageQueue.poll();
    }

    /** See who's next without removing them from the queue. */
    public Patient peekNextPatient() {
        if (triageQueue.isEmpty()) {
            throw new NoSuchElementException("No patients waiting");
        }
        return triageQueue.peek();
    }

    public boolean isEmpty() {
        return triageQueue.isEmpty();
    }

    public int waitingCount() {
        return triageQueue.size();
    }

    // Simple demo
    public static void main(String[] args) {
        ERTriageSystem er = new ERTriageSystem();

        er.admitPatient(3, "Alice");   // moderate
        er.admitPatient(1, "Bob");     // critical
        er.admitPatient(5, "Carol");   // minor
        er.admitPatient(2, "Dave");    // urgent
        er.admitPatient(1, "Eve");     // critical, arrived after Bob

        System.out.println("Next up: " + er.peekNextPatient()); // Bob (priority=1)

        System.out.println("Calling: " + er.callNextPatient()); // Bob   (priority 1, arrived first)
        System.out.println("Calling: " + er.callNextPatient()); // Eve   (priority 1, arrived second)
        System.out.println("Calling: " + er.callNextPatient()); // Dave  (priority 2)
        System.out.println("Calling: " + er.callNextPatient()); // Alice (priority 3)
        System.out.println("Calling: " + er.callNextPatient()); // Carol (priority 5)

        try {
            er.callNextPatient(); // empty, throws
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}