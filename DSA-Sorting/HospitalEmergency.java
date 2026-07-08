import java.util.Scanner;

public class HospitalEmergency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read size N and K
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] priorities = new int[n];
        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }
        sc.close();
        
        // The kth highest element is at index (k - 1) if sorted in descending order,
        // or index (n - k) if sorted in ascending order.
        int targetIndex = n - k;
        int result = quickSelect(priorities, 0, n - 1, targetIndex);
        
        System.out.println(result);
    }

    private static int quickSelect(int[] arr, int low, int high, int targetIndex) {
        if (low == high) return arr[low];
        
        // Partition the array around a pivot
        int pivotIndex = partition(arr, low, high);
        
        // If the pivot is at the target index, we found our kth highest element
        if (pivotIndex == targetIndex) {
            return arr[pivotIndex];
        } 
        // If target is less than pivot index, look in the left partition
        else if (targetIndex < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, targetIndex);
        } 
        // Otherwise, look in the right partition
        else {
            return quickSelect(arr, pivotIndex + 1, high, targetIndex);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}