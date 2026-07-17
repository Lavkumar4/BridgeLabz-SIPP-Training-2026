import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // canonical signature
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solver = new GroupAnagrams();

        String[] tickets = {"login issue", "issue login", "payment failed", "failed payment", "app crash"};
        List<List<String>> result = solver.groupAnagrams(tickets);

        for (List<String> group : result) {
            System.out.println(group);
        }
        // Groups "login issue"/"issue login" together, "payment failed"/"failed payment" together,
        // and "app crash" alone
    }
}