import java.util.Scanner;

public class BubbleSortPrices {

    public static void bubbleSort(long[] prices) {
        int n = prices.length;
        boolean swapped;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place, so we skip them
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (prices[j] > prices[j + 1]) {
                    // Swap prices[j] and prices[j+1]
                    long temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;

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
        Scanner sc = new Scanner(System.in);

        // Read size of the array
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        // Using long data type because prices can be up to 10^9
        long[] prices = new long[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextLong();
        }

        // Perform Bubble Sort
        bubbleSort(prices);

        // Print the sorted output in the expected bracket format
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(prices[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}