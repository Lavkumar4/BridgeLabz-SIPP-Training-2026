public class BSTInsert {
    // Definition for a binary tree node.
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Inserts a new employee ID into the BST using the return-and-reassign pattern.
     * * @param node The current node in the BST traversal.
     * @param id   The new employee ID to insert.
     * @return The updated node reference to link back to the parent.
     */
    public Node insert(Node node, int id) {
        // Base case: We've reached the insertion point (a null child pointer)
        if (node == null) {
            return new Node(id);
        }

        // Recurse down the tree based on the value comparison
        if (id < node.val) {
            // Reassign the left child with the result of the recursive insert
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            // Reassign the right child with the result of the recursive insert
            node.right = insert(node.right, id);
        }
        
        // If id == node.val, we do nothing (assuming duplicates aren't allowed)

        // Return the unchanged node pointer back up the call stack
        return node;
    }
}