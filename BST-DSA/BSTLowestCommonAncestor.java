public class BSTLowestCommonAncestor {
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
     * Finds the Lowest Common Ancestor (LCA) of two departments in a BST.
     * * @param root The root node of the organizational BST.
     * @param p    The department code of employee 1.
     * @param q    The department code of employee 2.
     * @return The Node representing the lowest common ancestor scope.
     */
    public Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root;

        while (current != null) {
            // Case 1: Both targets are smaller than the current node.
            // The LCA must be in the left subtree.
            if (p < current.val && q < current.val) {
                current = current.left;
            } 
            // Case 2: Both targets are larger than the current node.
            // The LCA must be in the right subtree.
            else if (p > current.val && q > current.val) {
                current = current.right;
            } 
            // Case 3: A split point has occurred! 
            // Current is either between p and q, or is equal to one of them.
            else {
                return current;
            }
        }

        return null;
    }
}