class ChargingStation {

    // Static Variables
    static int totalStations = 0;
    static double electricityRate = 8.5; // ₹ per unit

    // Instance Variables
    String stationId;
    double unitsConsumed;

    // Constructor
    ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    // Calculate Bill
    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    // Display Details
    void displayStationDetails() {
        System.out.println("Station ID      : " + stationId);
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Electricity Rate: ₹" + electricityRate + "/unit");
        System.out.println("Bill Amount     : ₹" + calculateBill());
        System.out.println();
    }
}

public class ElectricVechile {
    public static void main(String[] args) {

        ChargingStation s1 = new ChargingStation("CS101", 100);
        ChargingStation s2 = new ChargingStation("CS102", 120);
        ChargingStation s3 = new ChargingStation("CS103", 150);
        ChargingStation s4 = new ChargingStation("CS104", 180);
        ChargingStation s5 = new ChargingStation("CS105", 200);

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total Stations = "
                           + ChargingStation.totalStations);

        // Change electricity rate
        ChargingStation.electricityRate = 10.0;

        System.out.println("\nAfter Rate Change:");

        s1.displayStationDetails();
        s2.displayStationDetails();
    }
}