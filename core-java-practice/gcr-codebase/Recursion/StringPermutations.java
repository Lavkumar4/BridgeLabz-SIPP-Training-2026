import java.util.Scanner;
public class StringPermutations {
    static void generatePermutations(String str, String ans) {

        // Base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recursive case
        for (int i = 0; i < str.length(); i++) {

            char currentChar = str.charAt(i);

            String remaining =
                    str.substring(0, i) + str.substring(i + 1);

            generatePermutations(remaining, ans + currentChar);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        generatePermutations(str, "");
        sc.close();
    }
}