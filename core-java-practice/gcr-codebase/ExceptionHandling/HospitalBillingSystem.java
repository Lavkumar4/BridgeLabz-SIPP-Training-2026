import java.util.Scanner;

// Custom Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    public static void processPayment(double billAmount, double payment)
            throws InsufficientFundsException {
        if (payment < billAmount) {
            throw new InsufficientFundsException(
                    "Payment failed: Insufficient funds!");
        }
        System.out.println("Payment successful.");
        System.out.println("Change returned: " + (payment - billAmount));
    }
    public static void main(String[] args) {
        String[] patients = {"Rahul", "Priya", "Amit"};
        Scanner sc = new Scanner(System.in);
        try {
            // Patient Index Input
            System.out.print("Enter patient index (0-2): ");
            int index = Integer.parseInt(sc.nextLine());

            System.out.println("Patient: " + patients[index]);

            // Billing Information
            System.out.print("Enter total bill amount: ");
            double totalBill = Double.parseDouble(sc.nextLine());

            System.out.print("Enter number of items/services: ");
            int items = Integer.parseInt(sc.nextLine());

            // Division operation
            double averageCost = totalBill / items;

            System.out.println("Average cost per item: " + averageCost);

            // Payment
            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(sc.nextLine());

            processPayment(totalBill, payment);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");

        } catch (ArithmeticException e) {
            System.out.println("Error: Bill cannot be divided by zero items.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter numeric values only.");

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());

        } finally {
            System.out.println("Hospital billing process completed.");
            sc.close();
        }
    }
}