import java.util.ArrayList;
import java.util.List;

public class FeatureFlagTester {

    public List<List<String>> generateFlagCombinations(String[] flags) {
        List<List<String>> result = new ArrayList<>();
        backtrack(flags, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String[] flags, int index, List<String> current, List<List<String>> result) {
        // Base Case: We've made a decision for every flag
        if (index == flags.length) {
            result.add(new ArrayList<>(current)); // Make a copy of current state
            return;
        }

        // Choice 1: Enable the flag (ON)
        current.add(flags[index]);
        backtrack(flags, index + 1, current, result);

        // Backtrack: Undo the choice (Un-choose)
        current.remove(current.size() - 1);

        // Choice 2: Disable the flag (OFF)
        backtrack(flags, index + 1, current, result);
    }
}

/**
[ ] (index 0: dark_mode)
                          /   \
                         /     \
             +dark_mode /       \ (skip)
                       /         \
          ["dark_mode"]           [ ] (index 1: beta_search)
             /      \             /   \
  +beta_search /        \  +beta   /     \ (skip)
             /          \         /       \
  ["dark_mode",   ["dark_mode"] ["beta_"]  [ ]  <-- Base Cases (index == 2)
   "beta_search"]                "search"
   
   /**