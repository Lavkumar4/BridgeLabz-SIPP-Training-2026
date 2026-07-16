import java.util.*;

public class PrintServer {

    private final Deque<Integer> printQueue = new ArrayDeque<>();

    /** A normal job is submitted — joins the back of the line. */
    public void submitJob(int jobId) {
        printQueue.addLast(jobId);
    }

    /** An urgent job jumps to the very front, ahead of everything waiting. */
    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
    }

    /** The printer picks up whatever is next in line, from the front. */
    public int printNextJob() {
        if (printQueue.isEmpty()) {
            throw new NoSuchElementException("No jobs in the queue");
        }
        return printQueue.removeFirst();
    }

    public boolean isEmpty() {
        return printQueue.isEmpty();
    }

    public int pendingCount() {
        return printQueue.size();
    }

    // Simple demo
    public static void main(String[] args) {
        PrintServer server = new PrintServer();

        server.submitJob(1); // normal job, back of line: [1]
        server.submitJob(2); // normal job, back of line: [1, 2]
        server.submitJob(3); // normal job, back of line: [1, 2, 3]

        System.out.println("Printing: " + server.printNextJob()); // 1 (FIFO, normal order)

        server.submitJob(4);       // back of line:  [2, 3, 4]
        server.submitUrgentJob(99); // urgent, jumps to front: [99, 2, 3, 4]

        System.out.println("Printing: " + server.printNextJob()); // 99 (urgent job, printed next)
        System.out.println("Printing: " + server.printNextJob()); // 2  (back to normal FIFO order)

        server.submitUrgentJob(100); // urgent: [100, 3, 4]
        server.submitUrgentJob(101); // urgent: [101, 100, 3, 4]  <- most recent urgent job wins the front

        System.out.println("Printing: " + server.printNextJob()); // 101
        System.out.println("Printing: " + server.printNextJob()); // 100
        System.out.println("Printing: " + server.printNextJob()); // 3
        System.out.println("Printing: " + server.printNextJob()); // 4

        try {
            server.printNextJob(); // empty, throws
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}