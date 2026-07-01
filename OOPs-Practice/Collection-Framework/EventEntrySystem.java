import java.util.HashSet;
import java.util.Scanner;

public class EventEntrySystem {
    public static void main(String[] args) {
        // HashSet to store unique email IDs
        HashSet<String> participants = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String email;

        System.out.println("--- Tech Conference Registration System ---");
        System.out.println("Enter email IDs to register (type 'exit' to finish):");

        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine().trim().toLowerCase();

            if (email.equalsIgnoreCase("exit")) {
                break;
            }

            // Attempt to add to HashSet
            // .add() returns false if the element already exists
            if (participants.add(email)) {
                System.out.println("Registration successful: " + email);
            } else {
                System.out.println("Registration rejected: " + email + " is already registered.");
            }
        }

        // Displaying results
        System.out.println("\n--- Registration Summary ---");
        System.out.println("Total unique attendees: " + participants.size());
        System.out.println("List of registered participants:");
        
        for (String participant : participants) {
            System.out.println(" - " + participant);
        }

        scanner.close();
    }
}