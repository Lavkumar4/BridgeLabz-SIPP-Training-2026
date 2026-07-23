import java.util.*;

public class DeliveryRouteExplorer {

    public static List<List<Integer>> findAllRoutes(Map<Integer, List<Integer>> roads, int start, int target) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        dfsAllPaths(roads, start, target, currentPath, visited, allRoutes);
        return allRoutes;
    }

    private static void dfsAllPaths(Map<Integer, List<Integer>> roads, 
                                    int current, 
                                    int target, 
                                    List<Integer> path, 
                                    Set<Integer> visited, 
                                    List<List<Integer>> allRoutes) {
        // Choose: Add node to current path and visited set
        path.add(current);
        visited.add(current);

        // Target reached: Save a copy of the current valid path
        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            // Explore all unvisited neighbors
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    dfsAllPaths(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        // Backtrack: Remove node from path and visited set before returning up the recursion stack
        path.remove(path.size() - 1);
        visited.remove(current);
    }
}

/**

Graph Layout:
0 ---> 1 ---> 3
|      |
v      v
2 -----+

Exploration Steps:
Path 1: [0 -> 1 -> 3]  (Found target! Snapshot path: [0, 1, 3])
        Backtrack 3, Backtrack 1.

Path 2: [0 -> 1 -> 2]  (Dead end / loop check)
        Backtrack 2, Backtrack 1.

Path 3: [0 -> 2 -> 1 -> 3] (Found target! Snapshot path: [0, 2, 1, 3])
        Backtrack 3, Backtrack 1, Backtrack 2, Backtrack 0.

Resulting Paths: [[0, 1, 3], [0, 2, 1, 3]]
/**