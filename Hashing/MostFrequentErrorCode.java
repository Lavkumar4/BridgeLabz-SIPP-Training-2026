import java.util.HashMap;
import java.util.Map;

public class MostFrequentErrorCode {

    public int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>();
        int bestCode = codes[0], bestCount = 0;

        for (int code : codes) {
            int count = freq.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }
        return bestCode;
    }

    public static void main(String[] args) {
        MostFrequentErrorCode solver = new MostFrequentErrorCode();

        int[] codes = {404, 500, 500, 404, 500, 403, 404, 500};
        System.out.println("Most frequent error code: " + solver.mostFrequentErrorCode(codes)); // 500
    }
}