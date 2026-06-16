import java.util.Scanner;
public class Printnumber {
    static void printNumbers(int n) {
        if (n == 0) {   // Base case
            return;
        }
        System.out.print(n + " ");
        printNumbers(n - 1);  // Recursive call
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        printNumbers(N);

        sc.close();
    }
}