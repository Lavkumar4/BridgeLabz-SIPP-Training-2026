public class BSTDelete {
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
     * Deletes a target SKU from the BST and returns the updated node reference.
     * * @param node The current node in the traversal.
     * @param sku  The SKU value to delete.
     * @return The updated structural reference.
     */
    public Node delete(Node node, int sku) {
        // Base case: The target SKU does not exist in the tree
        if (node == null) {
            return null;
        }

        // Phase 1: Search for the node to delete
        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {
            // Phase 2: Found the target node! Handle the 3 structural cases:

            // Case 1: The node is a leaf (no children)
            if (node.left == null && node.right == null) {
                return null; // Returning null detaches this node from its parent
            }

            // Case 2: The node has exactly one child
            if (node.left == null) {
                return node.right; // Bypass 'node' and return its right child
            }
            if (node.right == null) {
                return node.left; // Bypass 'node' and return its left child
            }

            // Case 3: The node has two children
            // Find the in-order successor (smallest node in the right subtree)
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }

            // Copy the successor's value over to this node, effectively "replacing" it
            node.val = successor.val;

            // Recursively delete the successor node from the right subtree
            node.right = delete(node.right, successor.val);
        }

        return node;
    }
}