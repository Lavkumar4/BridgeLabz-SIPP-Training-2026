class Node {
    String serverName;
    Node next;

    public Node(String serverName) {
        this.serverName = serverName;
        this.next = null;
    }
}

public class ServerChain {

    /**
     * Finds the middle server in the relay chain in a single pass.
     * * @param head The head of the server chain.
     * @return The node representing the midpoint server.
     */
    public Node findMiddleServer(Node head) {
        // Edge case: An empty chain or a chain with only one server
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Move fast at 2x speed and slow at 1x speed
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches the end, slow is at the middle
        return slow;
    }
}