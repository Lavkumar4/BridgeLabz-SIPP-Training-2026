import java.util.Scanner;

public class StudentFeeDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter Student Fee: ");
        double fee = input.nextDouble();

        System.out.print("Enter University Discount Percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate discount amount
        double discount = (fee * discountPercent) / 100;

        // Calculate final fee
        double finalFee = fee - discount;

        // Display results
        System.out.println("The discount amount is INR " + discount);
        System.out.println("The final discounted fee is INR " + finalFee);

        input.close();
    }
}