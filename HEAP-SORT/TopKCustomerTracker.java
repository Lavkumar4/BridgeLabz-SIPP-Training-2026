import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKCustomerTracker {

    public static List<Integer> topKLargest(int[] transactions, int k) {
        if (k <= 0 || transactions.length == 0) {
            return new ArrayList<>();
        }

        // Java's default PriorityQueue is a Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int amount : transactions) {
            if (minHeap.size() < k) {
                // Phase 1: Fill heap until it reaches capacity k
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                // Phase 2: If current amount beats the smallest in top-k, swap it out
                minHeap.poll();
                minHeap.offer(amount);
            }
            // If amount <= minHeap.peek(), do nothing!
        }

        return new ArrayList<>(minHeap);
    }
}

/**Step 1: Process 150 -> Heap size < 3 -> Add 150
Heap: [150]

Step 2: Process 80 -> Heap size < 3 -> Add 80
Heap: [80, 150]  (Min at root = 80)

Step 3: Process 200 -> Heap size < 3 -> Add 200
Heap: [80, 150, 200]  (Top 3 set is now full; root = 80)

Step 4: Process 300 -> 300 > Root (80)
Action: Poll 80, Offer 300
Heap: [150, 300, 200]  (New root = 150)

Step 5: Process 50 -> 50 <= Root (150)
Action: Ignore 50
Heap remains: [150, 300, 200]

Final Top 3: [150, 200, 300]/**