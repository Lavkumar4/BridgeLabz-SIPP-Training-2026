// Interface 1
interface LuggageScanner {

    void scanLuggage(double luggageWeight);

    default void displaySecurityGuidelines() {
        System.out.println("Luggage Guidelines: Do not carry prohibited items.");
    }
}

// Interface 2
interface PassportVerifier {

    void verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport Guidelines: Carry a valid passport.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo.length() == 8;
    }
}

// Implementing Class
class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    @Override
    public void scanLuggage(double luggageWeight) {
        if (luggageWeight <= 25) {
            System.out.println("Luggage Check: Passed");
        } else {
            System.out.println("Luggage Check: Failed (Overweight)");
        }
    }

    @Override
    public void verifyPassport(String passportNo) {
        if (PassportVerifier.isPassportNumberValid(passportNo)) {
            System.out.println("Passport Verification: Passed");
        } else {
            System.out.println("Passport Verification: Failed");
        }
    }

    // Resolve default method conflict
    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public boolean canBoard(String passportNo, double luggageWeight) {
        return PassportVerifier.isPassportNumberValid(passportNo)
                && luggageWeight <= 25;
    }
}

// Main Class
public class AirportSecurityDemo {

    public static void main(String[] args) {

        String[] passengerNames = {
                "Rahul",
                "Priya",
                "Aman",
                "Sneha"
        };

        String[] passportNumbers = {
                "AB123456",
                "P123",
                "XY987654",
                "MN456789"
        };

        double[] luggageWeights = {
                20.5,
                18.0,
                30.0,
                22.0
        };

        AirportSecuritySystem security = new AirportSecuritySystem();

        System.out.println("=== Security Guidelines ===");
        security.displaySecurityGuidelines();

        System.out.println("\n=== Passenger Verification ===");

        for (int i = 0; i < passengerNames.length; i++) {

            System.out.println("\nPassenger: " + passengerNames[i]);

            security.verifyPassport(passportNumbers[i]);
            security.scanLuggage(luggageWeights[i]);

            if (security.canBoard(passportNumbers[i], luggageWeights[i])) {
                System.out.println("Boarding Status: Allowed");
            } else {
                System.out.println("Boarding Status: Not Allowed");
            }
        }
    }
}