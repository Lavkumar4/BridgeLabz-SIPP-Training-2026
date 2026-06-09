import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Calculate maximum handshakes
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display result
        System.out.println("The maximum number of possible handshakes is " + handshakes);

        input.close();
    }
}