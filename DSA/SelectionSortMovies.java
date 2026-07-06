import java.util.Scanner;

public class SelectionSortMovies {
    
    public static void selectionSort(int[] ratings) {
        int n = ratings.length;
        
        // Move the boundary of the unsorted subarray one by one
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the remaining unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIdx]) {
                    minIdx = j;
                }
            }
            
            // Swap the found minimum element with the first unsorted element
            int temp = ratings[minIdx];
            ratings[minIdx] = ratings[i];
            ratings[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read size of the array
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int[] ratings = new int[n];
        
        // Read array elements
        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }
        
        // Perform Selection Sort
        selectionSort(ratings);
        
        // Print the sorted output format matching the examples
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(ratings[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        
        sc.close();
    }
}