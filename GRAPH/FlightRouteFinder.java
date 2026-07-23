/**
Graph Routes:
0 -> [1, 2]
1 -> [3]
2 -> [3, 4]
3 -> [4]

BFS Propagation Order:
Level 0 (0 Layovers):  [0]
Level 1 (1 Layover):   [1, 2]
Level 2 (2 Layovers):  [3, 4]  <-- Destination 4 found at Level 2!

Path Reconstruction via Parent Map:
destination (4) <-- parent.get(4) is (2) <-- parent.get(2) is (0)
Reconstructed Path: [0 -> 2 -> 4]
/**

import java.util.*;

public class FlightRouteFinder {

    public static List<Integer> fewestFlights(Map<Integer, List<Integer>> routes, int origin, int destination) {
        if (origin == destination) {
            return Collections.singletonList(origin);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        // Initialize BFS from origin
        queue.offer(origin);
        visited.add(origin);
        parentMap.put(origin, null); // Origin has no parent

        boolean found = false;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                found = true;
                break;
            }

            for (int neighbor : routes.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current); // Record parent for path reconstruction
                    queue.offer(neighbor);
                }
            }
        }

        // Destination was never reached
        if (!found && !visited.contains(destination)) {
            return Collections.emptyList();
        }

        // Reconstruct the path by traversing backward from destination to origin
        LinkedList<Integer> path = new LinkedList<>();
        Integer currNode = destination;

        while (currNode != null) {
            path.addFirst(currNode); // Add to front so order is origin -> destination
            currNode = parentMap.get(currNode);
        }

        return path;
    }
}