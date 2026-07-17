import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OrgChartExporter {

    // Definition for an Organizational Chart Node
    public static class Node {
        int val; // Represents Employee/Manager ID
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Iteratively exports the hierarchy using preorder traversal (Root -> Left -> Right).
     * Uses a heap-allocated Deque as an explicit stack to prevent StackOverflowError.
     */
    public List<Integer> iterativePreorder(Node root) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: empty tree
        if (root == null) {
            return result;
        }

        // Deque is the standard Java recommendation for Stack implementations
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // Process the current manager/node
            Node node = stack.pop();
            result.add(node.val);

            // Push right child first, so the left child sits on top and gets popped next
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    // Quick verification
    public static void main(String[] args) {
        OrgChartExporter exporter = new OrgChartExporter();

        /* Constructing a sample deep hierarchy:
                 1 (CEO)
                / \
               2   5
              / \
             3   4
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        List<Integer> flatHierarchy = exporter.iterativePreorder(root);
        
        // Output will be: [1, 2, 3, 4, 5] (Preorder: Manager always before reports)
        System.out.println("Serialized Org Chart: " + flatHierarchy);
    }
}