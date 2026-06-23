class Drone {

    // Instance Variables
    String droneId;
    int batteryPercentage;

    // Static Variable
    static String companyName = "Sky Logistics";

    // Constructor
    Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    // Method to start delivery
    void startDelivery() {
        System.out.println(droneId + " has started delivery.");
    }

    // Method to display status
    void displayStatus() {
        System.out.println("Company Name      : " + companyName);
        System.out.println("Drone ID          : " + droneId);
        System.out.println("Battery Percentage: " + batteryPercentage + "%");
        System.out.println();
    }
}

public class DroneSystem {
    public static void main(String[] args) {

        Drone d1 = new Drone("DR101", 90);
        Drone d2 = new Drone("DR102", 75);
        Drone d3 = new Drone("DR103", 60);

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        System.out.println();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}