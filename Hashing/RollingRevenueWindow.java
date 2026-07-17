import java.util.HashMap;
import java.util.Map;

public class RollingRevenueWindow {

    public int subarraySumEqualsK(int[] revenueChanges, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int runningSum = 0, answer = 0;

        for (int change : revenueChanges) {
            runningSum += change;
            answer += prefixCount.getOrDefault(runningSum - k, 0);
            prefixCount.merge(runningSum, 1, Integer::sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        RollingRevenueWindow solver = new RollingRevenueWindow();

        int[] revenueChanges = {4, -4, 3, -3, 2, -2};
        int k = 0;

        System.out.println("Revenue-neutral windows: " + solver.subarraySumEqualsK(revenueChanges, k));
        // Should count all contiguous ranges summing to 0
    }
}