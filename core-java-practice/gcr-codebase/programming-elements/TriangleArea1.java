import java.util.Scanner;

public class TriangleArea1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for base and height in cm
        System.out.print("Enter the base (in cm): ");
        double base = input.nextDouble();

        System.out.print("Enter the height (in cm): ");
        double height = input.nextDouble();

        // Calculate area in square centimeters
        double areaSqCm = 0.5 * base * height;

        // Convert square centimeters to square inches
        // 1 inch = 2.54 cm
        // 1 sq inch = (2.54 * 2.54) sq cm
        double areaSqIn = areaSqCm / (2.54 * 2.54);

        // Display results
        System.out.println("The Area of the triangle in sq in is "
                + areaSqIn + " and sq cm is " + areaSqCm);

        input.close();
    }
}