import java.util.Arrays;

public class SelectionSortScores {
    
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            
            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {78, 45, 99, 83, 52};
        
        System.out.println("Original Exam Scores: " + Arrays.toString(examScores));
        
        // Sort the array
        selectionSort(examScores);
        
        System.out.println("Sorted Exam Scores (Ascending): " + Arrays.toString(examScores));
    }
}