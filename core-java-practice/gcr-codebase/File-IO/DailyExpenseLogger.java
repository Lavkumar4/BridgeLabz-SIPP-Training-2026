import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter("expenses.txt", true))) {

            System.out.print("Enter Expense Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            bw.write(category + " - " + amount);
            bw.newLine();

            System.out.println("Expense saved successfully!");

        } catch (IOException e) {
            System.out.println("Error while writing to file: "
                    + e.getMessage());
        }

        sc.close();
    }
}