public class PairSum {

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {5000, 10000, 15000, 20000, 25000, 30000};
        int target = 45000;

        int[] result = findPairSum(transactions, target);

        if (result[0] == -1) {
            System.out.println("Pair Not Found");
        } else {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}