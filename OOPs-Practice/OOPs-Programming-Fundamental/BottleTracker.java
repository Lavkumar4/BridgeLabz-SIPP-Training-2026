class WaterBottle {

    // Instance Variables
    String ownerName;
    double dailyTarget; // in liters

    // Constructor
    WaterBottle(String ownerName, double dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    // Method to display bottle information
    void displayBottleInfo() {
        System.out.println("Owner Name  : " + ownerName);
        System.out.println("Daily Target: " + dailyTarget + " Liters");
        System.out.println();
    }
}

public class BottleTracker {
    public static void main(String[] args) {

        // Create two bottle objects
        WaterBottle bottle1 = new WaterBottle("Lav", 3.0);
        WaterBottle bottle2 = new WaterBottle("Rahul", 2.5);

        // Display information
        bottle1.displayBottleInfo();
        bottle2.displayBottleInfo();
    }
}