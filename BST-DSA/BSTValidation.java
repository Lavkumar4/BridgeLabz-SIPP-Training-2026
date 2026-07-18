public class BSTValidation {
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
     * Checks if the given binary tree is a valid BST.
     * * @param root The root node of the tree.
     * @return true if the tree is a valid BST, false otherwise.
     */
    public boolean isValidBST(Node root) {
        // Use Long.MIN_VALUE and Long.MAX_VALUE to comfortably handle 
        // Integer.MIN_VALUE or Integer.MAX_VALUE if they exist as keys.
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(Node node, long min, long max) {
        // Base case: An empty tree or reaching past a leaf is valid
        if (node == null) {
            return true;
        }

        // The critical integrity check: Is the current node out of its global bounds?
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recurse down both sides, updating the valid range dynamically:
        // Left child: must be smaller than the current node's value (updates upper bound)
        // Right child: must be larger than the current node's value (updates lower bound)
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}