import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] nums) {
        int n = nums.length;
        
        // Loop from the second element up to the last element
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            
            /* Move elements of nums[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            
            // Place the key into its correct sorted slot
            nums[j + 1] = key;
        }
        
        return nums;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {12, 11, 13, 5, 6};
        System.out.println("Example 1 Sorted: " + Arrays.toString(insertionSort(nums1)));
        
        // Example 2
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println("Example 2 Sorted: " + Arrays.toString(insertionSort(nums2)));
    }
}