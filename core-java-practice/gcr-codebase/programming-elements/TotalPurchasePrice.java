import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter unit price: ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        // Calculate total price
        double totalPrice = unitPrice * quantity;

        // Display result
        System.out.println("The total purchase price is INR " 
                           + totalPrice 
                           + " if the quantity " 
                           + quantity 
                           + " and unit price is INR " 
                           + unitPrice);

        input.close();
    }
}