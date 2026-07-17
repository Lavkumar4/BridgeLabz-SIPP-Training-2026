public class TreeMetricsAnalyzer {

    public static class Node {
        int val; // Category ID or Employee ID
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // Global tracker to capture the maximum diameter found during height calculation
    private int maxDiameter = 0;

    // ==========================================
    // SCENARIO 4: HEIGHT & THRESHOLD CHECK
    // ==========================================
    
    /**
     * Computes the height of the tree using the edge-counting convention.
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public int height(Node node) {
        if (node == null) {
            return -1; // Edge-counting convention base case
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }

    // ==========================================
    // SCENARIO 5: OPTIMIZED DIAMETER
    // ==========================================

    /**
     * Public method to find the longest communication path (diameter).
     * Time Complexity: O(n), Space Complexity: O(h)
     */
    public int getDiameter(Node root) {
        maxDiameter = 0; // Reset for calculation
        calculateHeightAndDiameter(root);
        return maxDiameter;
    }

    /**
     * Helper that calculates height while updating the maximum diameter globally.
     */
    private int calculateHeightAndDiameter(Node node) {
        if (node == null) {
            return -1;
        }

        // Post-order traversal: compute values from bottom up
        int leftHeight = calculateHeightAndDiameter(node.left);
        int rightHeight = calculateHeightAndDiameter(node.right);

        // The path passing through the current node combines the paths of both sides.
        // Since null returns -1, adding 2 bridges the edge connections correctly.
        int currentDiameter = leftHeight + rightHeight + 2;

        // Keep track of the largest path seen so far
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Return the height of this node back up to its parent
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Verification
    public static void main(String[] args) {
        TreeMetricsAnalyzer analyzer = new TreeMetricsAnalyzer();

        /* Constructing sample tree:
                 1
                / \
               2   3
              / \
             4   5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Scenario 4 Verification (Edge height should be 2: Path 1 -> 2 -> 4)
        int treeHeight = analyzer.height(root);
        System.out.println("Tree Height (Edges): " + treeHeight); 
        System.out.println("Is tree deeper than threshold 1? " + analyzer.isTooDeep(root, 1)); 

        // Scenario 5 Verification (Diameter should be 3: Path 4 -> 2 -> 1 -> 3 or 5 -> 2 -> 1 -> 3)
        int treeDiameter = analyzer.getDiameter(root);
        System.out.println("Longest Communication Path (Diameter): " + treeDiameter); 
    }
}