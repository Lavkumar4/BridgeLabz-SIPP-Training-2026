import java.util.Arrays;
import java.util.Random;

public class LibrarySorter {

    // 1. MERGE SORT WITH O(N LOG N) TOTAL TIME (O(N) MERGE STEP)
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        mergeSort(left);
        mergeSort(right);
        
        merge(arr, left, right);
    }

    /**
     * The linear O(n) merge step that reconstructs the partitioned sections.
     */
    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        // Sweep up any remaining elements
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
    }


    // 2. QUICK SORT WITH 3-WAY LOMUTO PARTITIONING
    public static void quickSort3Way(int[] arr, int low, int high) {
        if (low < high) {
            // partitions[0] is 'lt' boundary, partitions[1] is 'gt' boundary
            int[] partitions = lomutoPartition3Way(arr, low, high);
            
            quickSort3Way(arr, low, partitions[0] - 1);
            quickSort3Way(arr, partitions[1] + 1, high);
        }
    }

    private static int[] lomutoPartition3Way(int[] arr, int low, int high) {
        // Pivot selection (using the first element as base, randomized swap can be added)
        int pivot = arr[low];
        
        int lt = low;       // Elements from low to lt-1 are < pivot
        int i = low + 1;    // Elements from lt to i-1 are == pivot
        int gt = high;      // Elements from gt+1 to high are > pivot
        
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        // Return both boundaries to bypass duplicates in the next recursive steps
        return new int[]{lt, gt};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 3. COUNTING SORT FOR BOUNDED GENRE CODES (1–20)
    public static int[] countingSortGenres(int[] arr, int minVal, int maxVal) {
        int range = maxVal - minVal + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // 1. Frequency tally
        for (int num : arr) {
            count[num - minVal]++;
        }
        
        // 2. Prefix sum transformation to establish positioning indices
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        // 3. Construct output array backwards to guarantee a stable sort
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - minVal] - 1] = arr[i];
            count[arr[i] - minVal]--;
        }
        
        return output;
    }

 
    // EMPIRICAL PERFORMANCE BENCHMARK RUNNER
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random random = new Random();
        
        System.out.printf("%-10s | %-15s | %-18s | %-15s%n", "Size (N)", "Merge Sort", "Quick Sort 3-Way", "Counting Sort");
        System.out.println("---------------------------------------------------------------------");
        
        for (int size : sizes) {
            // Generate mock array containing genre values strictly between 1 and 20
            int[] masterArray = new int[size];
            for (int i = 0; i < size; i++) {
                masterArray[i] = random.nextInt(20) + 1; 
            }
            
            // --- Merge Sort Benchmark ---
            int[] mergeTarget = masterArray.clone();
            long start = System.nanoTime();
            mergeSort(mergeTarget);
            double mergeTime = (System.nanoTime() - start) / 1_000_000.0; // convert to ms
            
            // --- Quick Sort 3-Way Benchmark ---
            int[] quickTarget = masterArray.clone();
            start = System.nanoTime();
            quickSort3Way(quickTarget, 0, quickTarget.length - 1);
            double quickTime = (System.nanoTime() - start) / 1_000_000.0;
            
            // --- Counting Sort Benchmark ---
            int[] countingTarget = masterArray.clone();
            start = System.nanoTime();
            countingSortGenres(countingTarget, 1, 20);
            double countingTime = (System.nanoTime() - start) / 1_000_000.0;
            
            System.out.printf("%-10d | %-12.4f ms | %-15.4f ms | %-12.4f ms%n", 
                    size, mergeTime, quickTime, countingTime);
        }
    }
}