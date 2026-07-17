import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AnnouncementBroadcaster {

    public static class Node {
        int val; // Employee ID
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Groups employee IDs by their depth level using Breadth-First Search (BFS).
     */
    public List<List<Integer>> broadcastByLevel(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>(); // ArrayDeque is generally faster than LinkedList for simple Queue operations
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Snapshot the exact size of the current tier/level
            int levelSize = queue.size();
            List<Integer> currentLevelValues = new ArrayList<>();

            // Process exactly 'levelSize' nodes for this specific tier
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                currentLevelValues.add(node.val);

                // Queue up the next layer of management
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Append the entire level's results to the output
            result.add(currentLevelValues);
        }

        return result;
    }
}