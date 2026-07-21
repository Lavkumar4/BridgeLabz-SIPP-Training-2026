public class EmbeddedSensorSorter {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Phase 1: Build Max-Heap in-place - O(n)
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }

        // Phase 2: Extract elements one by one from the heap - O(n log n)
        for (int end = n - 1; end > 0; end--) {
            // Move current root (maximum) to the end of array
            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;

            // Restore max-heap property on the reduced active heap [0...end-1]
            siftDownMax(arr, 0, end);
        }
    }

    private static void siftDownMax(int[] arr, int i, int activeSize) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < activeSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < activeSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively sift down affected sub-tree
            siftDownMax(arr, largest, activeSize);
        }
    }
}
/**
Unsorted: [4, 10, 3, 5, 1]  ===>  Max-Heap Array: [10, 5, 3, 4, 1]
                                           [10]
                                          /    \
                                        [5]    [3]
                                       /   \
                                     [4]   [1]
									 
									 Step 1: Swap root (10) with last element (1). Shrink heap size to 4.
Array: [1, 5, 3, 4 | 10]  (10 is now fixed at the end)
Sift down index 0 -> Active Heap: [5, 4, 3, 1 | 10]

Step 2: Swap root (5) with last element in heap (1). Shrink heap size to 3.
Array: [1, 4, 3 | 5, 10]  (5, 10 fixed)
Sift down index 0 -> Active Heap: [4, 1, 3 | 5, 10]

Step 3: Swap root (4) with last element in heap (3). Shrink heap size to 2.
Array: [3, 1 | 4, 5, 10]  (4, 5, 10 fixed)
Sift down index 0 -> Active Heap: [3, 1 | 4, 5, 10]

Step 4: Swap root (3) with last element in heap (1). Shrink heap size to 1.
Array: [1 | 3, 4, 5, 10]  (Fully sorted!)
/**