import java.util.*;

public class NetworkThroughputMonitor {

    public static int[] maxThroughputWindow(int[] readings, int k) {
        int n = readings.length;
        if (n == 0 || k <= 0 || k > n) {
            throw new IllegalArgumentException("Invalid input: n=" + n + ", k=" + k);
        }

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores INDICES, decreasing values front-to-back

        for (int i = 0; i < n; i++) {
            // 1. Evict from the FRONT: drop indices that have fallen outside the trailing window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Evict from the BACK: drop indices whose readings can never be the max again,
            //    now that a bigger-or-equal reading has arrived
            while (!deque.isEmpty() && readings[deque.peekLast()] <= readings[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Once we've seen at least k readings, the front of the deque is this window's max
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }

        return result;
    }

    // Simple demo
    public static void main(String[] args) {
        int[] readings = {4, 2, 9, 5, 6, 3, 8, 1};
        int k = 3;

        int[] result = maxThroughputWindow(readings, k);

        System.out.println("Readings: " + Arrays.toString(readings));
        System.out.println("Window size: " + k);
        System.out.println("Trailing max per window: " + Arrays.toString(result));
        // Window [4,2,9] -> 9
        // Window [2,9,5] -> 9
        // Window [9,5,6] -> 9
        // Window [5,6,3] -> 6
        // Window [6,3,8] -> 8
        // Window [3,8,1] -> 8
        // Expected: [9, 9, 9, 6, 8, 8]
    }
}