import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class FolderDeleter {

    public static class Node {
        String folderName;
        Node left;
        Node right;

        public Node(String folderName) {
            this.folderName = folderName;
        }
    }

    // A dummy deletion simulation
    private void deleteNode(Node node) {
        System.out.println("Deleted: " + node.folderName);
    }

    // ==========================================
    // RECURSIVE APPROACH
    // ==========================================
    /**
     * Safely deletes the tree bottom-up recursively.
     * Time: O(n), Space: O(h)
     */
    public void deleteFolderTreeRecursive(Node node) {
        if (node == null) return;

        // 1. Traverse and delete left children
        deleteFolderTreeRecursive(node.left);

        // 2. Traverse and delete right children
        deleteFolderTreeRecursive(node.right);

        // 3. Process the parent safely now that children are gone
        deleteNode(node);
    }

    // ==========================================
    // ITERATIVE APPROACH (Reversal Trick)
    // ==========================================
    /**
     * Iterative Postorder using two stacks to reverse a modified preorder.
     * Guarantees no StackOverflowError even with ultra-deep folder structures.
     * Time: O(n), Space: O(n)
     */
    public List<String> getSafeDeletionOrderIterative(Node root) {
        List<String> deletionOrder = new ArrayList<>();
        if (root == null) return deletionOrder;

        Deque<Node> traversalStack = new ArrayDeque<>();
        Deque<Node> outStack = new ArrayDeque<>();

        traversalStack.push(root);

        // Modified Preorder (Root -> Right -> Left) pushed onto outStack
        while (!traversalStack.isEmpty()) {
            Node curr = traversalStack.pop();
            outStack.push(curr);

            // Push left first so right is processed first (Root -> Right -> Left)
            if (curr.left != null) {
                traversalStack.push(curr.left);
            }
            if (curr.right != null) {
                traversalStack.push(curr.right);
            }
        }

        // Popping from outStack completely reverses the sequence to (Left -> Right -> Root)
        while (!outStack.isEmpty()) {
            deletionOrder.add(outStack.pop().folderName);
        }

        return deletionOrder;
    }

    // Verification
    public static void main(String[] args) {
        FolderDeleter deleter = new FolderDeleter();

        /* Constructing a directory tree:
                   Root_Folder
                    /       \
               Documents   Photos
                 /
             Resume.pdf
        */
        Node root = new Node("Root_Folder");
        root.left = new Node("Documents");
        root.right = new Node("Photos");
        root.left.left = new Node("Resume.pdf");

        System.out.println("--- Recursive Deletion Path ---");
        deleter.deleteFolderTreeRecursive(root);

        // Rebuild tree for iterative test
        Node root2 = new Node("Root_Folder");
        root2.left = new Node("Documents");
        root2.right = new Node("Photos");
        root2.left.left = new Node("Resume.pdf");

        System.out.println("\n--- Iterative Deletion Order ---");
        List<String> order = deleter.getSafeDeletionOrderIterative(root2);
        for (String folder : order) {
            System.out.println("Deleted: " + folder);
        }
    }
}