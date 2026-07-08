import java.util.Scanner;

public class Employee-Promotion-Conflicts-(Medium){
    private static long conflictCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/null") == null ? new Scanner(System.in) : new Scanner("4\n70 95 80 100"));
        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNext()) {
                String token = sc.next().replace("[", "").replace("]", "").replace(",", "");
                scores[i] = Integer.parseInt(token);
            }
        }
        sc.close();
        
        // Reset count and run modified merge sort
        conflictCount = 0;
        enhancedMergeSort(scores, 0, n - 1);
        
        System.out.println(conflictCount);
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
        int i = left;     // Pointer for left subarray (Seniors)
        int j = mid + 1;  // Pointer for right subarray (Juniors)
        int k = 0;
        
        while (i <= mid && j <= right) {
            // Standard inversion counting checks arr[i] > arr[j].
            // For conflict counting, we want to know when a Junior score is strictly greater
            // than a Senior score: arr[i] < arr[j].
            if (arr[i] < arr[j]) {
                // Since left subarray is sorted, if arr[i] < arr[j], 
                // then arr[i], arr[i+1], ..., arr[mid] are all smaller than arr[j].
                conflictCount += (mid - i + 1);
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
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