import java.util.*;

public class ConfigBracketValidator {

    public static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchFor = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Opening bracket: push it, we'll need to match it later
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // Closing bracket: must match the most recent unmatched opener
                if (stack.isEmpty() || stack.pop() != matchFor.get(c)) {
                    return false;
                }
            }
            // Any other character is ignored (e.g. config values, whitespace)
            // If you want strict validation of ONLY bracket characters,
            // throw/return false here instead.
        }

        // Valid only if every opener found a matching closer
        return stack.isEmpty();
    }

    // Simple demo
    public static void main(String[] args) {
        String[] tests = {
            "{[()()]}",      // valid
            "{[(])}",        // invalid: crossed/mismatched nesting
            "{[}",           // invalid: unclosed brackets
            "]",             // invalid: closer with nothing to match
            "{}",            // valid
            "",              // valid (empty is trivially balanced)
            "{ \"key\": [1, 2, (3)] }" // valid,