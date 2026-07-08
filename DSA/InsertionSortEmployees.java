import java.util.Arrays;

public class InsertionSortEmployees {
    
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        
        // Start from the second element (index 1) as the first element is implicitly "sorted"
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            
            /* Move elements of employeeIDs[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j = j - 1;
            }
            // Insert the key into its correct sorted position
            employeeIDs[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] empIDs = {105, 101, 108, 103, 102};
        
        System.out.println("Original Employee IDs: " + Arrays.toString(empIDs));
        
        // Sort the array
        insertionSort(empIDs);
        
        System.out.println("Sorted Employee IDs (Ascending): " + Arrays.toString(empIDs));
    }
}