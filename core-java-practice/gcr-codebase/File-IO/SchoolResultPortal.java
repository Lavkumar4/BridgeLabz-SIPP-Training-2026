import java.io.*;
import java.util.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        String inputFile = "students.txt";
        String outputFile = "reportcard.txt";

        try (
            BufferedReader reader = new BufferedReader(
                    new FileReader(inputFile));

            // true = append mode
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(outputFile, true))
        ) {

            String line;

            writer.write("\n===== REPORT CARD =====\n");

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];

                int total = 0;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = (double) total / (data.length - 1);

                writer.write("Name: " + name);
                writer.newLine();
                writer.write("Average Marks: " +
                             String.format("%.2f", average));
                writer.newLine();
                writer.write("----------------------");
                writer.newLine();
            }

            System.out.println("Report card generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println(
                "Error: Student data file not found."
            );

        } catch (IOException e) {
            System.out.println(
                "Error while reading/writing file: "
                + e.getMessage()
            );

        } catch (NumberFormatException e) {
            System.out.println(
                "Error: Invalid marks format in file."
            );
        }
    }
}