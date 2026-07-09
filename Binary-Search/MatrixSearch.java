public class MatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Handle edge cases: empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        // 1. Treat the matrix as a flattened 1D array
        int left = 0;
        int right = (numRows * numColumns) - 1;

        // 2. Perform standard binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 3. Map the 1D index 'mid' back to 2D matrix coordinates (row, col)
            int row = mid / numColumns;
            int col = mid % numColumns;

            int midValue = matrix[row][col];

            // 4. Compare with the target
            if (midValue == target) {
                return true; // Target found
            } else if (target < midValue) {
                right = mid - 1; // Search the left half
            } else {
                left = mid + 1;  // Search the right half
            }
        }

        // Target not present in the matrix
        return false;
    }

    public static void main(String[] args) {
        // Example: 3x4 matrix satisfying the sorted conditions
        int[][] matrix = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3;
        boolean found = searchMatrix(matrix, target);

        System.out.println("Target " + target + " found in matrix? " + found);
    }
}