import java.util.ArrayList;
import java.util.List;

public class LeaderboardSystem {

    // Definition for a Binary Search Tree Node
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Helper method to perform recursive inorder traversal.
     */
    private void inorder(Node node, List<Integer> result) {
        // Base case: if the current node is missing (null), stop recursion
        if (node == null) {
            return;
        }

        // 1. Traverse the left subtree (smaller scores)
        inorder(node.left, result);

        // 2. Visit the current node (add to leaderboard)
        result.add(node.val);

        // 3. Traverse the right subtree (larger scores)
        inorder(node.right, result);
    }

    /**
     * Public method to retrieve the sorted leaderboard.
     */
    public List<Integer> getSortedLeaderboard(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    // Quick demonstration of how it works
    public static void main(String[] args) {
        LeaderboardSystem system = new LeaderboardSystem();

        /* Constructing a sample BST:
                 50
                /  \
              30    70
             /  \     \
            20  40    80
        */
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.right = new Node(80);

        List<Integer> sortedLeaderboard = system.getSortedLeaderboard(root);
        
        // Output will be: [20, 30, 40, 50, 70, 80]
        System.out.println("Sorted Leaderboard: " + sortedLeaderboard);
    }
}