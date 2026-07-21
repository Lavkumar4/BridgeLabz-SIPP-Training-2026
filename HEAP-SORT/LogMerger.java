import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class LogEntry {
    long timestamp;
    String message;

    public LogEntry(long timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}

public class LogMerger {

    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        List<LogEntry> merged = new ArrayList<>();
        if (sources == null || sources.isEmpty()) return merged;

        // Min-Heap stores array pointer coordinates: {sourceIndex, elementIndex}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(
                sources.get(a[0]).get(a[1]).timestamp,
                sources.get(b[0]).get(b[1]).timestamp
            )
        );

        // Step 1: Seed the heap with the first log entry of each non-empty source file
        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0}); // {sourceIdx, elemIdx}
            }
        }

        // Step 2: Extract minimum and advance pointer for that source
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0];
            int elemIdx = top[1];

            merged.add(sources.get(sourceIdx).get(elemIdx));

            // If the same source has more entries, push the next candidate
            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elemIdx + 1});
            }
        }

        return merged;
    }
}

/**
Step 1: Seed Min-Heap with heads of A, B, and C (Size = 3)
Heap: [10:00 (A), 10:01 (B), 10:03 (C)]

Step 2: Poll 10:00 (A) -> Append to Merged list.
Next from Server A is 10:05 -> Offer 10:05 (A)
Heap: [10:01 (B), 10:03 (C), 10:05 (A)]

Step 3: Poll 10:01 (B) -> Append to Merged list.
Next from Server B is 10:08 -> Offer 10:08 (B)
Heap: [10:03 (C), 10:05 (A), 10:08 (B)]

Step 4: Poll 10:03 (C) -> Append to Merged list.
Next from Server C is 10:04 -> Offer 10:04 (C)
Heap: [10:04 (C), 10:05 (A), 10:08 (B)]

...Repeat until all sources are exhausted.
/**