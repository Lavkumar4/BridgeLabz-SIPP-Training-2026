public class OrgDiameterAnalyzer {

    // Definition for an Organizational Tree Node
    public static class Node {
        int val; // Employee ID
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Global tracker to capture the maximum path found
    private int maxDiameter;

    /**
     * Computes the diameter (longest path in edges) of the tree.
     * Time Complexity: O(n)
     * Space Complexity: O(h) for the call stack
     */
    public int longestCommunicationPath(Node root) {
        maxDiameter = 0; // Reset for each execution
        heightAndUpdateDiameter(root);
        return maxDiameter;
    }

    /**
     * Helper that calculates node height while simultaneously updating the max diameter.
     */
    private int heightAndUpdateDiameter(Node node) {
        // Base case: empty subtree has height -1 in edge-counting convention
        if (node == null) {
            return -1;
        }

        // Post-order: compute left and right subtree heights first
        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);

        // Update the global maximum diameter if the path passing through this node is longer.
        // Adding 2 bridges the edge connections from the current node to its two children.
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight + 2);

        // Return the height of this node to its parent
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Verification
    public static void main(String[] args) {
        OrgDiameterAnalyzer analyzer = new OrgDiameterAnalyzer();

        /* Constructing the example tree:
                   1 (CEO)
                  /
                 2 (VP)
                / \
               3   4 (Directors)
              /     \
             5       6 (Managers)
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left.left = new Node(5);
        root.left.right.right = new Node(6);

        int maxPath = analyzer.longestCommunicationPath(root);
        
        // Output should be 4 (Path: 5 -> 3 -> 2 -> 4 -> 6)
        System.out.println("Longest Communication Path: " + maxPath + " edges");
    }
}