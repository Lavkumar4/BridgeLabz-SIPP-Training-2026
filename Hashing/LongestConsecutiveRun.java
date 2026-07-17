import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveRun {

    public int longestConsecutiveRun(int[] ids) {
        Set<Integer> idSet = new HashSet<>();
        for (int id : ids) idSet.add(id);

        int longest = 0;
        for (int id : idSet) {
            if (!idSet.contains(id - 1)) { // only start a run at its true beginning
                int length = 1;
                int current = id;
                while (idSet.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveRun solver = new LongestConsecutiveRun();

        int[] ids = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive run: " + solver.longestConsecutiveRun(ids)); // 4
    }
}