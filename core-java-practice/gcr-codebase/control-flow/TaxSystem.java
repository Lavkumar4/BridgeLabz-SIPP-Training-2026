import java.util.Scanner;

public class TaxSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalTax = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter income of citizen " + i + ": ");
            double income = sc.nextDouble();

            double tax;
            String bracket;

            if (income < 10000) {
                tax = income * 0.05;
                bracket = "5%";
            } else if (income <= 50000) {
                tax = income * 0.15;
                bracket = "15%";
            } else {
                tax = income * 0.30;
                bracket = "30%";
            }

            System.out.println("Tax Bracket: " + bracket);
            System.out.println("Tax Amount: " + tax);
            System.out.println();

            totalTax += tax;
        }

        System.out.println("Total Tax Collected = " + totalTax);

        sc.close();
    }
}