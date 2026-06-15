import java.util.Scanner;

public class StringIndexDemo {

    static void generateException(String str) {
        System.out.println(str.charAt(str.length()));
    }

    static void handleException(String str) {
        try {
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException Handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.next();

        // generateException(str); // Uncomment to see exception

        handleException(str);
    }
}