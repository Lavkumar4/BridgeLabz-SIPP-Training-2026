import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class FraudPairDetection {

    public int[] findFraudPair(int[] amounts, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // amount -> index
        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(amounts[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        FraudPairDetection detector = new FraudPairDetection();

        int[] amounts = {8500, 3000, 9500, 500, 9000};
        int target = 10000;

        int[] result = detector.findFraudPair(amounts, target);
        System.out.println("Indices: " + Arrays.toString(result)); // [1, 4] -> 3000 + 9000 = 10000
    }
}