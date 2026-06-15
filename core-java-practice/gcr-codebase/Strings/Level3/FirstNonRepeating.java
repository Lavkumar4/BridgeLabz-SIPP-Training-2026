import java.util.Scanner;

public class FirstNonRepeating {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String str = sc.nextLine();

        int[] freq = new int[256];

        for(int i=0;i<str.length();i++) {
            freq[str.charAt(i)]++;
        }

        for(int i=0;i<str.length();i++) {

            if(freq[str.charAt(i)] == 1) {
                System.out.println("First Non-Repeating Character = "
                                   + str.charAt(i));
                return;
            }
        }

        System.out.println("No Non-Repeating Character Found");
    }
}