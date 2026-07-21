import java.util.PriorityQueue;

public class AdmissionCutoff {

    public static int findKthLargest(int[] scores, int k) {
        if (scores == null || scores.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input or k exceeds applicant pool size.");
        }

        // Bounded Min-Heap of capacity k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }

        // The root contains the minimum of the top-k scores = k-th largest overall
        return minHeap.peek();
    }
}

/**Processed Scores: [72, 95, 88, 60, 85, 90, 78]

Step-by-Step Min-Heap (Size capped at k = 3):

1. Process 72, 95, 88  ==> Heap: [72, 95, 88] (Root = 72)
2. Process 60          ==> 60 <= 72 (Ignored)
3. Process 85          ==> 85 > 72  -> Poll 72, Offer 85  ==> Heap: [85, 95, 88] (Root = 85)
4. Process 90          ==> 90 > 85  -> Poll 85, Offer 90  ==> Heap: [88, 95, 90] (Root = 88)
5. Process 78          ==> 78 <= 8/**8 (Ignored)

Final Min-Heap:
       [88]  <-- Root is the 3rd largest score (Cutoff)
      /    \
    [95]   [90]/**