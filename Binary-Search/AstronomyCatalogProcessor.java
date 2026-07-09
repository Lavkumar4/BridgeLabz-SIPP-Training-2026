import java.util.Arrays;

public class AstronomyCatalogProcessor {

    /**
     * Extension 1: Find the Minimum Element (Inflection/Glitch Point)
     * Time Complexity: O(log n)
     */
    public static int findMinimum(double[] arr) {
        if (arr == null || arr.length == 0) return -1;
        
        int left = 0;
        int right = arr.length - 1;

        // If catalog isn't actually rotated, return the first element
        if (arr[left] <= arr[right]) return left;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost, min is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Otherwise, min is at mid or to its left
                right = mid;
            }
        }
        return left; // Returns the index of the minimum element
    }

    /**
     * Extension 2: Search for a Target Brightness in the Scrambled/Rotated Catalog
     * Time Complexity: O(log n)
     */
    public static int searchInRotatedCatalog(double[] arr, double target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;

            // Check if the left half is normally sorted
            if (arr[left] <= arr[mid]) {
                // Determine if target sits inside this clean left half
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Otherwise, the right half must be normally sorted
            else {
                // Determine if target sits inside this clean right half
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1; // Target not found
    }

    /**
     * Extension 3: Find First and Last Occurrence of a Repeated Brightness Value
     * Note: This expects a perfectly sorted (un-rotated) subsection or catalog.
     * Time Complexity: O(log n)
     */
    public static int[] findFirstAndLastOccurrence(double[] arr, double target) {
        int[] bounds = {-1, -1};
        bounds[0] = findBound(arr, target, true);  // Search Left Boundary
        bounds[1] = findBound(arr, target, false); // Search Right Boundary
        return bounds;
    }

    private static int findBound(double[] arr, double target, boolean lookForFirst) {
        int left = 0;
        int right = arr.length - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                resultIndex = mid; // Record the match
                if (lookForFirst) {
                    right = mid - 1; // Force search to continue leftward
                } else {
                    left = mid + 1;  // Force search to continue rightward
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resultIndex;
    }

    // Execution block simulating the astronomer's environment
    public static void main(String[] args) {
        // Mock Catalog: 10M entries is memory-heavy to initialize explicitly here,
        // so we demonstrate with a small representative array reflecting the exact same logic.
        
        // Simulating a glitched, rotated sorted list of star magnitudes (lower is brighter)
        // Original sorted: [1.2, 2.4, 3.5, 3.5, 3.5, 4.1, 5.8, 6.2, 7.9]
        // Rotated around index 5:
        double[] scrambledCatalog = {4.1, 5.8, 6.2, 7.9, 1.2, 2.4, 3.5, 3.5, 3.5};
        
        System.out.println("--- Telescope Data Processing Execution ---");

        // 1. Find Minimum
        int minIndex = findMinimum(scrambledCatalog);
        System.out.println("Glitch Inflection Point (Min Element Index): " + minIndex);
        System.out.println("Brightest Star Magnitude Found: " + scrambledCatalog[minIndex]);

        System.out.println("-------------------------------------------");

        // 2. Search Rotated Catalog
        double targetBrightness = 6.2;
        int searchResult = searchInRotatedCatalog(scrambledCatalog, targetBrightness);
        System.out.println("Searching for Star Magnitude " + targetBrightness + "...");
        System.out.println("Target found at Catalog Index: " + searchResult);

        System.out.println("-------------------------------------------");

        // 3. Find Range Boundaries (Requires Un-rotated subset or sorted array)
        double[] sortedCatalogSubsection = {1.2, 2.4, 3.5, 3.5, 3.5, 4.1, 5.8, 6.2, 7.9};
        double repeatedTarget = 3.5;
        int[] range = findFirstAndLastOccurrence(sortedCatalogSubsection, repeatedTarget);
        System.out.println("Searching boundaries for cluster magnitude: " + repeatedTarget);
        System.out.println("First Occurence Index: " + range[0]);
        System.out.println("Last Occurence Index: " + range[1]);
        System.out.println("Total stars in this specific brightness band: " + (range[1] - range[0] + 1));
    }
}