import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take perimeter as input
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        // Calculate side length
        double side = perimeter / 4;

        // Display result
        System.out.println("The length of the side is " + side +
                           " whose perimeter is " + perimeter);

        input.close();
    }
}