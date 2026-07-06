import java.util.Scanner;

public class BubbleSortSwapCount {

    public static int getBubbleSortSwaps(int[] nums) {
        int n = nums.length;
        int swapCount = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (nums[j] > nums[j + 1]) {
                    // Swap elements
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    // Increment the counter
                    swapCount++;
                    swapped = true;
                }
            }

            // Optimization: If no elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        // Example 1 Test
        int[] nums1 = {4, 3, 2, 1};
        System.out.println("Total Swaps for Example 1: " + getBubbleSortSwaps(nums1)); // Output: 6

        // Example 2 Test
        int[] nums2 = {1, 2, 3};
        System.out.println("Total Swaps for Example 2: " + getBubbleSortSwaps(nums2)); // Output: 0
    }
}