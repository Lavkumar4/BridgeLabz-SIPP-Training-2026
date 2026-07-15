import java.util.*;

public class ServerLoadMonitor {

    public static int[] loadSpan(int[] load) {
        int n = load.length;
        int[] span = new int[n];

        Deque<Integer> stack = new ArrayDeque<>(); // indices, decreasing load values

        for (int i = 0; i < n; i++) {
            // Pop every prior index whose load is <= current load —
            // those readings can never "block" this one's span again.
            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) {
                stack.pop();
            }

            // If stack is empty, every prior reading was <= current -> span reaches back to day 0
            // Otherwise, span reaches back to (but not including) the nearest prior GREATER reading
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i);
        }

        return span;
    }

    // Simple demo
    public static void main(String[] args) {
        int[] load = {100, 80, 60, 70, 60, 75, 85};
        //             d0   d1  d2   d3  d4   d5  d6

        int[] result = loadSpan(load);

        for (int i = 0; i < load.length; i++) {
            System.out.println("Reading " + i + " (load=" + load[i] + ") -> span: " + result[i]);
        }
        // Reading 0 (load=100) -> span: 1
        // Reading 1 (load=80)  -> span: 1
        // Reading 2 (load=60)  -> span: 1
        // Reading 3 (load=70)  -> span: 2   (covers d3, d2)
        // Reading 4 (load=60)  -> span: 1
        // Reading 5 (load=75)  -> span: 4   (covers d5, d4, d3, d2)
        // Reading 6 (load=85)  -> span: 6   (covers d6..d1, blocked by d0=100)
    }
}