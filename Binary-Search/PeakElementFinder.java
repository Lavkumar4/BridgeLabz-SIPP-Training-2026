public class PeakElementFinder {

    public static int findPeakElementIndex(int[] arr) {
        // Handle edge case: empty array or single element
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;

        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element. 
            // We safely check boundaries so we don't look out of bounds.
            boolean greaterThanLeft = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean greaterThanRight = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (greaterThanLeft && greaterThanRight) {
                return mid; // Found a peak!
            }

            // If the left neighbor is greater, a peak must exist in the left half.
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } 
            // Otherwise, the right neighbor is greater, so a peak is in the right half.
            else {
                left = mid + 1;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        // Example array with multiple peaks: 3 (index 1) and 6 (index 5)
        int[] arr = {1, 3, 2, 0, 4, 6, 5};

        int peakIndex = findPeakElementIndex(arr);
        
        System.out.println("A peak element is found at index: " + peakIndex);
        System.out.println("The value of the peak element is: " + arr[peakIndex]);
    }
}