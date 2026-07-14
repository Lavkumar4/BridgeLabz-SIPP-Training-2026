class Node {
    String pageUrl;
    Node next;

    public Node(String pageUrl) {
        this.pageUrl = pageUrl;
        this.next = null;
    }
}

public class BrowserHistory {

    /**
     * Reverses the history list in-place.
     * * @param head The head of the current history list (most recent first).
     * @return The new head of the reversed history list (oldest first).
     */
    public Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            // 1. Stash the pointer to the rest of the unvisited list
            Node next = curr.next;

            // 2. Flip the pointer to point backward
            curr.next = prev;

            // 3. Move the 'prev' window forward to the current node
            prev = curr;

            // 4. Move the 'curr' window forward to the stashed next node
            curr = next;
        }

        // 'prev' is now pointing to what was the last node, which is the new head
        return prev;
    }
}