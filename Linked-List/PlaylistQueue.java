class Node {
    int trackId;
    Node next;

    public Node(int trackId) {
        this.trackId = trackId;
        this.next = null;
    }
}

public class PlaylistQueue {

    /**
     * Inserts a new track immediately after the currently playing track.
     * * @param current The node representing the currently playing track.
     * @param trackId The ID of the new track to be inserted.
     */
    public void insertAfter(Node current, int trackId) {
        // Edge case: If the current node is null, we cannot insert after it
        if (current == null) {
            System.out.println("Current track node cannot be null.");
            return;
        }

        // 1. Create the new track node
        Node newNode = new Node(trackId);

        // 2. Capture the rest of the queue first so we don't lose it
        newNode.next = current.next; 

        // 3. Link the current track to the new track
        current.next = newNode; 
    }
}