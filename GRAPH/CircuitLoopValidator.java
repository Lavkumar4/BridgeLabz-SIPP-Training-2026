import java.util.*;

public class CircuitLoopValidator {

    public static boolean hasWiringLoop(Map<Integer, List<Integer>> circuit, int n) {
        Set<Integer> visited = new HashSet<>();

        // Check all components (handles disconnected circuit sub-nets)
        for (int v = 0; v < n; v++) {
            if (!visited.contains(v)) {
                // Initial call for a component has no parent (-1)
                if (dfsCycleCheck(circuit, v, -1, visited)) {
                    return true; // Short-circuit defect found!
                }
            }
        }
        return false; // Circuit is a valid forest/tree structure
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> circuit, int node, int parent, Set<Integer> visited) {
        visited.add(node);

        for (int neighbor : circuit.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                // Recurse down the unvisited path
                if (dfsCycleCheck(circuit, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Neighbor was visited previously AND it's not our immediate parent -> Loop detected!
                return true;
            }
        }

        return false;
    }
}

/**
Case A: Valid Tree (No Cycle)
Node 0 --- Node 1 --- Node 2

Trace:
1. Start DFS at 0 (parent = -1). Mark visited: {0}.
2. Visit neighbor 1 (parent = 0). Mark visited: {0, 1}.
3. From 1, look at neighbors:
   - Neighbor 0: visited, BUT neighbor == parent (0 == 0). Ignored!
   - Neighbor 2: unvisited. Move to 2 (parent = 1).
4. No loop detected. Return false.


Case B: Redundant Loop (Cycle Exists)
Node 0 --- Node 1
  |         |
  +-- Node 2+

Trace:
1. Start DFS at 0 (parent = -1). Mark visited: {0}.
2. Visit neighbor 1 (parent = 0). Mark visited: {0, 1}.
3. Visit neighbor 2 (parent = 1). Mark visited: {0, 1, 2}.
4. From 2, look at neighbors:
   - Neighbor 1: visited, BUT neighbor == parent (1 == 1). Ignored!
   - Neighbor 0: visited AND neighbor != parent (0 != 1). CYCLE DETECTED!
   /**