import java.util.Scanner;

public class SplitWords {

    static String[] splitText(String text) {
        return text.split(" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        String[] words = splitText(text);

        for(String w : words) {
            System.out.println(w);
        }
    }
}