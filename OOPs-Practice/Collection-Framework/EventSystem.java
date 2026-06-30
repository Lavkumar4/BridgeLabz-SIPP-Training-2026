import java.util.HashSet;

class EventRegistration {
    // HashSet unique ईमेल आईडी स्टोर करने के लिए
    private HashSet<String> registeredParticipants = new HashSet<>();

    // 1. Register new participant
    public void register(String email) {
        // .add() method HashSet में boolean return करता है:
        // true: अगर element successfully add हो गया
        // false: अगर element पहले से मौजूद था (duplicate)
        if (registeredParticipants.add(email)) {
            System.out.println("✅ Registration successful: " + email);
        } else {
            System.out.println("❌ Registration failed: " + email + " is already registered!");
        }
    }

    // 2. Display all participants
    public void displayParticipants() {
        System.out.println("\n--- Registered Participants List ---");
        if (registeredParticipants.isEmpty()) {
            System.out.println("No registrations yet.");
        } else {
            for (String email : registeredParticipants) {
                System.out.println("- " + email);
            }
        }
        System.out.println("------------------------------------");
    }

    // 3. Show total count
    public void showTotalCount() {
        System.out.println("Total eligible attendees: " + registeredParticipants.size());
    }
}

public class EventSystem {
    public static void main(String[] args) {
        EventRegistration event = new EventRegistration();

        // Testing registrations
        event.register("alice@tech.com");
        event.register("bob@dev.com");
        event.register("alice@tech.com"); // Duplicate attempt
        event.register("charlie@web.com");

        // Display results
        event.displayParticipants();
        event.showTotalCount();
    }
}