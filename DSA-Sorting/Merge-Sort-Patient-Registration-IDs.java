import java.util.Scanner;

public class Merge-Sort-Patient-Registration-IDs{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read N (Number of orders)
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        // Read order values (ignoring any brackets if present in the input)
        int[] orders = new int[n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNext()) {
                String token = sc.next().replace("[", "").replace("]", "");
                orders[i] = Integer.parseInt(token);
            }
        }
        sc.close();
        
        // Perform Merge Sort
        mergeSort(orders, 0, n - 1);
        
        // Print output in the required format: [300 420 650 850 1200]
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(orders[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        
        // Divide into left and right halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        // Conquer / Merge step
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Temporary array to store merged elements
        int[] temp = new int[right - left + 1];
        
        int i = left;     // Pointer for left subarray
        int j = mid + 1;  // Pointer for right subarray
        int k = 0;        // Pointer for temp array
        
        // Compare and copy elements into temp
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        // Copy any remaining elements from left side
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        // Copy any remaining elements from right side
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Copy back the sorted elements into the original array
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}