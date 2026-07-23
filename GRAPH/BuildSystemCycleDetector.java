import java.util.*;

public class BuildSystemCycleDetector {

    // Node States
    private static final int UNVISITED = 0; // WHITE
    private static final int VISITING  = 1; // GRAY  (In recursion stack)
    private static final int VISITED   = 2; // BLACK (Fully processed)

    public static boolean hasCircularDependency(Map<Integer, List<Integer>> taskGraph, int numTasks) {
        int[] state = new int[numTasks]; // Defaults to 0 (UNVISITED)

        // Iterate through all tasks to ensure disconnected components are checked
        for (int task = 0; task < numTasks; task++) {
            if (state[task] == UNVISITED) {
                if (dfsCycleCheck(taskGraph, task, state)) {
                    return true; // Circular dependency detected!
                }
            }
        }
        return false; // Valid Directed Acyclic Graph (DAG)
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> graph, int node, int[] state) {
        // Mark node as currently being explored (on the active path)
        state[node] = VISITING;

        for (int dep : graph.getOrDefault(node, Collections.emptyList())) {
            // Case 1: Dependency is currently on the active stack -> Cycle!
            if (state[dep] == VISITING) {
                return true;
            }

            // Case 2: Dependency has not been visited yet -> Recurse
            if (state[dep] == UNVISITED && dfsCycleCheck(graph, dep, state)) {
                return true;
            }

            // Case 3: state[dep] == VISITED -> Already safe, ignore.
        }

        // Mark node as fully processed before returning up the call stack
        state[node] = VISITED;
        return false;
    }
}

/**
Diamond Case (No Cycle):                  Circular Dependency Case (Cycle):
       [A]                                          [A]
      /   \                                          |
    [B]   [C]                                        v
      \   /                                         [B] <----+
       v v                                           |       |
       [D]                                           v       |
                                                    [C] -----+

Trace on Diamond Case:                      Trace on Cycle Case:
1. DFS(A): A becomes GRAY                   1. DFS(A): A becomes GRAY
2. DFS(B): B becomes GRAY                   2. DFS(B): B becomes GRAY
3. DFS(D): D becomes GRAY                   3. DFS(C): C becomes GRAY
4. D has no neighbors -> D becomes BLACK.   4. C looks at neighbor B: B is GRAY!
5. B completed -> B becomes BLACK.             ==> BACK EDGE DETECTED!
6. DFS(C): C becomes GRAY.                     ==> CIRCULAR DEPENDENCY FOUND!
7. C looks at D: D is BLACK (Safe!).
8. C becomes BLACK -> A becomes BLACK.
   (No cycle reported)
   /**