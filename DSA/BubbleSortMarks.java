import java.util.Arrays;

public class BubbleSortMarks {
    
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        
        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Last i elements are already in place, so we look at n - i - 1
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    
                    swapped = true;
                }
            }
            
            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {85, 92, 67, 74, 98, 50};
        
        System.out.println("Original Marks: " + Arrays.toString(studentMarks));
        
        // Sort the array
        bubbleSort(studentMarks);
        
        System.out.println("Sorted Marks (Ascending): " + Arrays.toString(studentMarks));
    }
}