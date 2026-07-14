class Node {
    long timestamp; // using long for timestamp comparison
    String logMessage;
    Node next;

    public Node(long timestamp) {
        this.timestamp = timestamp;
        this.next = null;
    }
}

public class LogMerger {

    /**
     * Merges two sorted log streams into a single sorted log stream in-place.
     * * @param a The head of the first sorted log stream.
     * @param b The head of the second sorted log stream.
     * @return The head of the newly merged, sorted log stream.
     */
    public Node mergeLogStreams(Node a, Node b) {
        // Create a dummy placeholder node to build upon
        Node dummy = new Node(0);
        // Track the end of our newly merged list
        Node tail = dummy;

        // Traverse both streams until one runs dry
        while (a != null && b != null) {
            if (a.timestamp <= b.timestamp) {
                tail.next = a;  // Append node from stream A
                a = a.next;     // Advance stream A
            } else {
                tail.next = b;  // Append node from stream B
                b = b.next;     // Advance stream B
            }
            tail = tail.next;   // Advance the tail pointer
        }

        // Fast-forward: attach the remainder of whichever list is left over
        tail.next = (a != null) ? a : b;

        // The actual head of the merged list sits right after the dummy node
        return dummy.next;
    }
}