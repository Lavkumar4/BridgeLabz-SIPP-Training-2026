import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take height in centimeters
        System.out.print("Enter your height in centimeters: ");
        double height = input.nextDouble();

        // Convert cm to inches
        double totalInches = height / 2.54;

        // Convert inches to feet and remaining inches
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        // Display result
        System.out.println("Your Height in cm is " + height +
                           " while in feet is " + feet +
                           " and inches is " + String.format("%.2f", inches));

        input.close();
    }
}