import java.util.Scanner;

public class Website-Response-Analysis{
    private static long violationCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input dynamically (handles standalone integers or spaces)
        if (!sc.hasNextInt()) return;
        
        // Assuming a dynamic structure or reading the entire line if N isn't explicitly given
        String line = sc.nextLine().trim();
        if (line.isEmpty() && sc.hasNextLine()) {
            line = sc.nextLine().trim();
        }
        
        String[] tokens = line.split("\\s+");
        int n = tokens.length;
        int[] responseTimes = new int[n];
        for (int i = 0; i < n; i++) {
            responseTimes[i] = Integer.parseInt(tokens[i]);
        }
        sc.close();
        
        // Reset counter and run modified merge sort
        violationCount = 0;
        enhancedMergeSort(responseTimes, 0, n - 1);
        
        System.out.println(violationCount);
    }

    private static void enhancedMergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        
        enhancedMergeSort(arr, left, mid);
        enhancedMergeSort(arr, mid + 1, right);
        
        mergeAndCount(arr, left, mid, right);
    }

    private static void mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;     // Pointer for left subarray
        int j = mid + 1;  // Pointer for right subarray
        int k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // If arr[i] > arr[j], then all elements from index i to mid 
                // in the left subarray form a violation with arr[j]
                violationCount += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        
        // Copy remaining elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Copy back to original array
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}