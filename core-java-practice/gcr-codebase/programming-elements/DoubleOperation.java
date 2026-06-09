import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input values
        System.out.print("Enter value of a: ");
        double a = input.nextDouble();

        System.out.print("Enter value of b: ");
        double b = input.nextDouble();

        System.out.print("Enter value of c: ");
        double c = input.nextDouble();

        // Perform double operations
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        // Display results
        System.out.println("The results of Double Operations are "
                + result1 + ", "
                + result2 + ", "
                + result3 + ", and "
                + result4);

        input.close();
    }
}