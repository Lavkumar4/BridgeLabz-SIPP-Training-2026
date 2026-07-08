import java.util.Scanner;

public class MergeCustomerRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read sizes of both branches
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] branchA = new int[n];
        for (int i = 0; i < n; i++) branchA[i] = sc.nextInt();
        
        int[] branchB = new int[m];
        for (int i = 0; i < m; i++) branchB[i] = sc.nextInt();
        sc.close();
        
        // Merge lists
        int[] mergedList = merge(branchA, branchB);
        
        // Print the result
        for (int i = 0; i < mergedList.length; i++) {
            System.out.print(mergedList[i]);
            if (i < mergedList.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        // Compare elements from both lists sequentially
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        // Append remaining elements from branchA if any
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        // Append remaining elements from branchB if any
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }
}