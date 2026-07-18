public class BSTSearch {
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
     * Searches for a target value in a Binary Search Tree iteratively.
     * * @param root   The root node of the BST.
     * @param target The integer value to search for.
     * @return true if the target exists in the tree, false otherwise.
     */
    public boolean search(Node root, int target) {
        Node current = root;
        
        // Traverse the tree until we hit a null leaf pointer
        while (current != null) {
            if (target == current.val) {
                return true; // Target found!
            }
            
            // Decisive comparison: eliminate half the remaining tree
            current = (target < current.val) ? current.left : current.right;
        }
        
        return false; // Target not found in the tree
    }
}