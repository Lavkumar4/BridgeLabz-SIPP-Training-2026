import java.util.Scanner;
public class ReverseStringRecursion {
    static String reverse(String str) {
        // Base case
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case
        return reverse(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
        sc.close();
    }
}