import java.util.Scanner;

public class Bank-Fraud-Detection-(Hard){
    private static int suspiciousPairsCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input format cleanly
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int[] amounts = new int[n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNext()) {
                String token = sc.next().replace("[", "").replace("]", "").replace(",", "");
                amounts[i] = Integer.parseInt(token);
            }
        }
        sc.close();
        
        // Reset counter and run the enhanced merge sort
        suspiciousPairsCount = 0;
        enhancedMergeSort(amounts, 0, n - 1);
        
        System.out.println(suspiciousPairsCount);
    }

    private static void enhancedMergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        
        enhancedMergeSort(arr, left, mid);
        enhancedMergeSort(arr, mid + 1, right);
        
        // Count suspicious pairs before executing the standard merge rule
        countPairs(arr, left, mid, right);
        
        // Standard merge to keep subarrays sorted
        merge(arr, left, mid, right);
    }

    private static void countPairs(int[] arr, int left, int mid, int right) {
        int j = mid + 1;
        
        // Scan through the left sorted array
        for (int i = left; i <= mid; i++) {
            // Using long casting to avoid any potential integer overflow when multiplying by 3
            while (j <= right && arr[i] > 3 * (long) arr[j]) {
                j++;
            }
            // All elements from (mid + 1) up to (j - 1) satisfy the condition for the current arr[i]
            suspiciousPairsCount += (j - (mid + 1));
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}