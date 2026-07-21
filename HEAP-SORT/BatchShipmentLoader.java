public class BatchShipmentLoader {

    // Transforms an unsorted array into a Min-Heap in O(n) time
    public static void buildHeap(int[] priorities) {
        int n = priorities.length;

        // Start from the last non-leaf node and move backward to the root
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(priorities, i, n);
        }
    }

    private static void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            // Swap current node with smallest child
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively sift down the affected sub-tree
            siftDown(arr, smallest, size);
        }
    }
}