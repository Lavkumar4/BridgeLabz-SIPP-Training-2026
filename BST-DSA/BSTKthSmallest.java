import java.util.ArrayDeque;
import java.util.Deque;

public class BSTKthSmallest {
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
     * Finds the k-th smallest value in a BST using iterative in-order traversal.
     * * @param root The root node of the BST.
     * @param k    The 1-based index of the smallest element to find.
     * @return The k-th smallest value.
     */
    public int kthSmallest(Node root, int k) {
        // Use Deque for an efficient LIFO stack implementation
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        int count = 0;

        // Traverse the tree
        while (current != null || !stack.isEmpty()) {
            // Step 1: Go as deep left as possible, pushing nodes onto the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Step 2: Process the current node (smallest available)
            current = stack.pop();
            count++;

            // Early termination check
            if (count == k) {
                return current.val;
            }

            // Step 3: Move to the right subtree
            current = current.right;
        }

        throw new IllegalArgumentException("k is out of bounds for this tree");
    }
}