import java.util.HashSet;
import java.util.Set;

public class DuplicateTokenDetector {

    public boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) { // add() returns false if already present
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateTokenDetector detector = new DuplicateTokenDetector();

        String[] tokensWithDuplicate = {"tok_a1", "tok_b2", "tok_c3", "tok_b2"};
        String[] tokensAllUnique = {"tok_a1", "tok_b2", "tok_c3", "tok_d4"};

        System.out.println("Has duplicate: " + detector.hasDuplicateToken(tokensWithDuplicate)); // true
        System.out.println("Has duplicate: " + detector.hasDuplicateToken(tokensAllUnique));      // false
    }
}