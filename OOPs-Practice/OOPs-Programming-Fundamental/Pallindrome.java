class PalindromeChecker {
    String text;

    // Constructor
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check palindrome
    boolean isPalindrome() {
        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        return text.equalsIgnoreCase(reversed);
    }

    // Method to display result
    void displayResult() {
        System.out.println("Text: " + text);

        if (isPalindrome()) {
            System.out.println("Result: Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }
    }
}

public class Pallindrome {
    public static void main(String[] args) {
        PalindromeChecker p = new PalindromeChecker("madam");

        p.displayResult();
    }
}