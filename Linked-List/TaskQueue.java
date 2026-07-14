class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class TaskQueue {

    /**
     * Removes a completed task by its ID from the queue.
     * * @param head   The head of the task queue.
     * @param taskId The ID of the task to be removed.
     * @return The (possibly updated) head of the queue.
     */
    public Node removeTask(Node head, int taskId) {
        // Edge case: Empty queue
        if (head == null) {
            return null;
        }

        // Case 1: The task to remove is at the very front (the head)
        if (head.val == taskId) {
            return head.next; // The second node becomes the new head
        }

        // Case 2: The task is further down the queue
        Node prev = head;
        Node curr = head.next;

        // Search for the task while keeping track of the previous node
        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }

        // If the task was found, bypass it
        if (curr != null) {
            prev.next = curr.next;
        }

        // Return the original head (which didn't change in Case 2)
        return head;
    }
}