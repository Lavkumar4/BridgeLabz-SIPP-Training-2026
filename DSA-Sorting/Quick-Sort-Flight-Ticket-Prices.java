import java.util.Scanner;

public class Quick-Sort-Flight-Ticket-Prices{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read N (Number of ticket prices)
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        // Read ticket prices (cleaning any brackets if included)
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNext()) {
                String token = sc.next().replace("[", "").replace("]", "");
                prices[i] = Integer.parseInt(token);
            }
        }
        sc.close();
        
        // Perform Quick Sort
        quickSort(prices, 0, n - 1);
        
        // Print the sorted array separated by spaces
        for (int i = 0; i < n; i++) {
            System.out.print(prices[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partitionIndex is the index where the pivot is now in its correct sorted position
            int partitionIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Using the last element as the pivot
        int pivot = arr[high];  
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the element at i + 1 so it sits in the middle
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}