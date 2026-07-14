class Node {
    String url;
    Node next;

    public Node(String url) {
        this.url = url;
        this.next = null;
    }
}

public class RedirectChecker {

    /**
     * Determines whether the redirect chain contains an infinite loop (cycle).
     * * @param head The start of the redirect chain.
     * @return true if a loop is detected, false otherwise.
     */
    public boolean hasRedirectLoop(Node head) {
        // Edge case: An empty chain or a single redirect cannot have a loop
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move 1 step
            fast = fast.next.next;    // Move 2 steps

            // If they meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end of the list, there is no loop
        return false;
    }
}