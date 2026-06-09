import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the base of the triangle: ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle: ");
        double height = input.nextDouble();

        // Calculate area
        double area = 0.5 * base * height;

        // Display result
        System.out.println("The area of the triangle is " + area + " square units.");

        input.close();
    }
}