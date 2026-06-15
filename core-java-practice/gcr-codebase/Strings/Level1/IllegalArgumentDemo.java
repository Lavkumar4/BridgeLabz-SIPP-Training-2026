import java.util.Scanner;

public class IllegalArgumentDemo {

    static void generateException(String str) {
        System.out.println(str.substring(5, 2));
    }

    static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException Handled");
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