import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class employees {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N (Number of employees)
        String line1 = br.readLine();
        if (line1 == null || line1.trim().isEmpty()) return;
        int n = Integer.parseInt(line1.trim());
        
        // Read salaries
        String line2 = br.readLine();
        if (line2 == null) return;
        
        // Clean formatting if brackets are passed in input
        line2 = line2.replace("[", "").replace("]", "").trim();
        
        int[] salaries = new int[n];
        StringTokenizer st = new StringTokenizer(line2);
        for (int i = 0; i < n; i++) {
            if (st.hasMoreTokens()) {
                salaries[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        // Perform Merge Sort
        mergeSort(salaries, 0, n - 1);
        
        // Format Output matching: [32000 40000 45000 55000 60000 78000]
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            sb.append(salaries[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        
        System.out.println(sb.toString());
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left and right halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left; // Initial index of merged subarray
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}