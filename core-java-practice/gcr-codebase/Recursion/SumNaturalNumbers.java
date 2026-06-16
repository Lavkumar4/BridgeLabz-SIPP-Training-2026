import java.util.Scanner;
public class SumNaturalNumbers {
    static int findSum(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }
        // Recursive case
        return n + findSum(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findSum(n));
        sc.close();
    }
}