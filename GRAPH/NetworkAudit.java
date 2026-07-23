import java.util.*;

public class NetworkAudit {

    public static int countNetworkSegments(Map<Integer, List<Integer>> network, int n) {
        Set<Integer> visited = new HashSet<>();
        int segments = 0;

        // Iterate through all servers from 0 to n-1
        for (int server = 0; server < n; server++) {
            // If the server hasn't been visited yet, we found a new isolated segment!
            if (!visited.contains(server)) {
                segments++;
                // Perform DFS/BFS to visit every server reachable within this segment
                dfsMark(network, server, visited);
            }
        }

        return segments;
    }

    private static void dfsMark(Map<Integer, List<Integer>> network, int node, Set<Integer> visited) {
        visited.add(node);

        for (int neighbor : network.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsMark(network, neighbor, visited);
            }
        }
    }

    public static boolean isFullyConnected(Map<Integer, List<Integer>> network, int n) {
        if (n <= 1) return true;
        return countNetworkSegments(network, n) == 1;
    }
}

/**
Server Network Structure:

   Component 1            Component 2       Component 3
   [0] --- [1]               [3]               [6]
    |       |                 |
   [2] -----+                [4] --- [5]

Outer Loop Execution Trace:
- server = 0: Not visited! Increments segments to 1.
              DFS visits and marks {0, 1, 2}.
- server = 1: Already in visited set. Skip.
- server = 2: Already in visited set. Skip.
- server = 3: Not visited! Increments segments to 2.
              DFS visits and marks {3, 4, 5}.
- server = 4: Already in visited set. Skip.
- server = 5: Already in visited set. Skip.
- server = 6: Not visited! Increments segments to 3.
              DFS visits and marks {6}.

Final Result: 3 Connected Components (Network is NOT fully connected).
/**