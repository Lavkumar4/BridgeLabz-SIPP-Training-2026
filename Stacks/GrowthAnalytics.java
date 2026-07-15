import java.util.*;

public class GrowthAnalytics {

    public static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // stores INDICES, not values

        for (int i = 0; i < n; i++) {
            // While the current day's count beats whatever day is waiting
            // on top of the stack, that waiting day has found its answer.
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                int dayIndex = stack.pop();
                answer[dayIndex] = visitors[i];
            }
            stack.push(i);
        }

        // Anything left on the stack never found a busier future day -> stays -1
        return answer;
    }

    // Simple demo
    public static void main(String[] args) {
        int[] visitors = {120, 90, 150, 140, 200, 80, 100};
        //                 d0   d1   d2   d3   d4   d5   d6

        int[] result = nextBusierDay(visitors);

        for (int i = 0; i < visitors.length; i++) {
            System.out.println("Day " + i + " (" + visitors[i] + " visitors) -> next busier: "
                + (result[i] == -1 ? "none" : result[i]));
        }
        // Day 0 (120) -> next busier: 150
        // Day 1 (90)  -> next busier: 150
        // Day 2 (150) -> next busier: 200
        // Day 3 (140) -> next busier: 200
        // Day 4 (200) -> next busier: none
        // Day 5 (80)  -> next busier: 100
        // Day 6 (100) -> next busier: none
    }
}