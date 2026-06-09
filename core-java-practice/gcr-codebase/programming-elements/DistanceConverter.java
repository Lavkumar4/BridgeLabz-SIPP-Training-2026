import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take distance in feet as input
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();

        // Convert feet to yards
        double yards = distanceInFeet / 3;

        // Convert yards to miles
        double miles = yards / 1760;

        // Display result
        System.out.println("Distance in feet is " + distanceInFeet);
        System.out.println("Distance in yards is " + yards);
        System.out.println("Distance in miles is " + miles);

        input.close();
    }
}