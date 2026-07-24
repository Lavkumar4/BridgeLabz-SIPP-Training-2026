import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachineChange {

    public List<List<Integer>> makeChange(int[] coins, int target) {
        Arrays.sort(coins); // Step 1: Sort to enable pruning
        List<List<Integer>> result = new ArrayList<>();
        backtrack(coins, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] coins, int target, int start, int sum, 
                          List<Integer> path, List<List<Integer>> result) {
        // Base Case: Target sum achieved
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Iterate over candidates starting from 'start' index to avoid duplicate permutations
        for (int i = start; i < coins.length; i++) {
            // Pruning: Since coins are sorted, if this coin exceeds target, rest will too
            if (sum + coins[i] > target) {
                break; 
            }

            path.add(coins[i]); // Choose
            
            // Pass 'i' (not 'i + 1') to allow reusing the current denomination
            backtrack(coins, target, i, sum + coins[i], path, result); // Explore
            
            path.remove(path.size() - 1); // Un-choose (Backtrack)
        }
    }
}

/**

sum = 0
                                 /   |   \
                     (1)        /    |    \ (2)    \ (5) -> 5 > 4 (Pruned)
                               /     |     \
                        sum = 1   sum = 2   sum = 5 ❌
                       /   |         |
           (1)        /    |(2)      |(2)
                     /     |         |
              sum = 2   sum = 3   sum = 4  ✅ [2, 2]
             /   |         |
 (1)        /    |(2)      |(2) -> 3+2=5 > 4 (Pruned)
           /     |         |
    sum = 3   sum = 4    sum = 5 ❌
     /           ✅ [1, 1, 2]
    / (1)
sum = 4  ✅ [1, 1, 1, 1]
/***