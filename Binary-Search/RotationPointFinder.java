public class RotationPointFinder {

    public static int findRotationPointIndex(int[] arr) {
        // Handle edge cases: empty array
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        // Binary Search loop
        while (left < right) {
            // Using this formula avoids potential integer overflow
            int mid = left + (right - left) / 2;

            // Case 1: Mid is greater than rightmost element.
            // This means the inflection point (smallest element) is in the right half.
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } 
            // Case 2: Mid is less than or equal to rightmost element.
            // This means the right half is properly sorted, so the smallest element 
            // must be at 'mid' itself or to its left.
            else {
                right = mid;
            }
        }

        // 'left' and 'right' converge to the index of the smallest element
        return left;
    }

    public static void main(String[] args) {
        // Example: Sorted array [1, 2, 3, 4, 5, 6, 7] rotated at index 4
        int[] rotatedArray = {5, 6, 7, 1, 2, 3, 4};

        int rotationIndex = findRotationPointIndex(rotatedArray);
        
        System.out.println("The rotation point is at index: " + rotationIndex);
        System.out.println("The smallest element (Value) is: " + rotatedArray[rotationIndex]);
    }
}