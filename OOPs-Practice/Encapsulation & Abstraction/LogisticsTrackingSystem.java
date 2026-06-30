// Base Class
class Package {
    private String trackingId;
    private double weight;

    // Constructor
    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;
        this.weight = weight;
    }

    // Getter for trackingId
    public String getTrackingId() {
        return trackingId;
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }

    // Setter for weight with validation
    public void setWeight(double weight) {
        if (weight <= 0.0) {
            System.out.println("Error: Weight must be greater than 0.");
        } else {
            this.weight = weight;
        }
    }
}

// Subclass
class ExpressPackage extends Package {
    private String priorityLevel;

    // Constructor
    public ExpressPackage(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }

    // Getter
    public String getPriorityLevel() {
        return priorityLevel;
    }

    // Method to print shipping label
    public void printShippingLabel() {
        System.out.println("===== SHIPPING LABEL =====");
        System.out.println("Tracking ID  : " + getTrackingId());
        System.out.println("Weight       : " + getWeight() + " kg");
        System.out.println("Priority     : " + priorityLevel);
        System.out.println("==========================");
    }
}

// Main Class
public class LogisticsTrackingSystem {
    public static void main(String[] args) {

        // Scenario A: Valid Input
        ExpressPackage pkg = new ExpressPackage(
                "EXP101",
                2.5,
                "Critical"
        );

        pkg.printShippingLabel();

        System.out.println("\nAttempting valid weight update...");
        pkg.setWeight(3.0);
        System.out.println("Updated Weight: " + pkg.getWeight());

        // Scenario B: Invalid Input
        System.out.println("\nAttempting invalid weight update...");
        pkg.setWeight(-1.5);

        System.out.println("Weight after invalid update: " + pkg.getWeight());

        System.out.println("\nAttempting invalid weight update...");
        pkg.setWeight(0.0);

        System.out.println("Weight after invalid update: " + pkg.getWeight());
    }
}