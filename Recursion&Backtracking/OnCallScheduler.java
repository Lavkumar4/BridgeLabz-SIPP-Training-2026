import java.util.ArrayList;
import java.util.List;

public class OnCallScheduler {

    public List<List<String>> generateSchedules(String[] engineers) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[engineers.length];
        backtrack(engineers, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String[] engineers, boolean[] used, 
                          List<String> path, List<List<String>> result) {
        // Base Case: Full schedule built
        if (path.size() == engineers.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try placing each unused engineer in the current day's slot
        for (int i = 0; i < engineers.length; i++) {
            if (used[i]) continue; // Skip if engineer is already on schedule

            // 1. Choose
            used[i] = true;
            path.add(engineers[i]);

            // 2. Explore
            backtrack(engineers, used, path, result);

            // 3. Un-choose (Backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

/***

[ ] (Depth 0)
                      /                |                \
         +A          /      +B         |         +C      \
                    /                  |                  \
                 ["A"]               ["B"]               ["C"]
                /     \             /     \             /     \
     +B        /       \ +C   +A   /       \ +C   +A   /       \ +B
              /         \         /         \         /         \
          ["A","B"]   ["A","C"] ["B","A"]  ["B","C"] ["C","A"]  ["C","B"]
             |           |         |          |         |          |
         +C  |       +B  |     +C  |      +A  |     +B  |      +A  |
             v           v         v          v         v          v
          [A,B,C]     [A,C,B]   [B,A,C]    [B,C,A]   [C,A,B]    [C,B,A]
          ✅          ✅        ✅         ✅        ✅         ✅
		  /***