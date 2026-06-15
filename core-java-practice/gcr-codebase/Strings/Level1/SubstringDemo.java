import java.util.Scanner;

public class SubStringDemo {

    static String getSubstring(String str, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }

        return result;
    }

    static boolean compare(String s1, String s2) {
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.next();

        System.out.print("Start index: ");
        int start = sc.nextInt();

        System.out.print("End index: ");
        int end = sc.nextInt();

        String sub1 = getSubstring(str, start, end);
        String sub2 = str.substring(start, end);

        System.out.println("User Substring: " + sub1);
        System.out.println("Built-in Substring: " + sub2);

        System.out.println("Same? " + compare(sub1, sub2));
    }
}
}
