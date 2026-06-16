import java.util.Scanner;
public class PalindromeRecursion {
    static boolean isPalindrome(String str, int start, int end) {
        // Base case
        if (start >= end) {
            return true;
        }
        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        sc.close();
    }
}