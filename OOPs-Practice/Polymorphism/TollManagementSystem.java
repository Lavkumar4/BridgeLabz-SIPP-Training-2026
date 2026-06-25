class Vehicle {
    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    double calculateToll() {
        return 0;
    }

    void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Owner Name     : " + ownerName);
    }
}

class Car extends Vehicle {

    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 100;
    }
}

class Bus extends Vehicle {

    Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 250;
    }
}

class Truck extends Vehicle {

    Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 400;
    }
}

public class TollManagementSystem {

    // Calculate Total Revenue
    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;

        for (Vehicle v : vehicles) {
            total += v.calculateToll();
        }

        return total;
    }

    // Search Vehicle
    static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {

        for (Vehicle v : vehicles) {

            if (v.vehicleNumber.equals(vehicleNumber)) {
                System.out.println("\nVehicle Found!");
                v.displayDetails();
                System.out.println("Toll Paid : ₹" + v.calculateToll());
                return;
            }
        }

        System.out.println("\nVehicle Not Found!");
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("UP81AB1234", "Lav"),
                new Bus("UP32CD5678", "Sharma Travels"),
                new Truck("RJ14EF9876", "ABC Logistics"),
                new Car("DL01GH4567", "Rahul"),
                new Truck("HR26JK1111", "XYZ Transport")
        };

        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;

        Vehicle highestTollVehicle = vehicles[0];

        System.out.println("===== Vehicle Details =====");

        for (Vehicle v : vehicles) {

            v.displayDetails();

            double toll = v.calculateToll();

            System.out.println("Toll Paid : ₹" + toll);
            System.out.println("-----------------------");

            // Count vehicle types
            if (v instanceof Car)
                carCount++;
            else if (v instanceof Bus)
                busCount++;
            else if (v instanceof Truck)
                truckCount++;

            // Highest toll vehicle
            if (toll > highestTollVehicle.calculateToll()) {
                highestTollVehicle = v;
            }
        }

        // Total Revenue
        System.out.println("\nTotal Revenue = ₹" +
                calculateTotalRevenue(vehicles));

        // Search Vehicle
        searchVehicle(vehicles, "RJ14EF9876");

        // Highest Toll Vehicle
        System.out.println("\n===== Highest Toll Vehicle =====");
        highestTollVehicle.displayDetails();
        System.out.println("Highest Toll : ₹" +
                highestTollVehicle.calculateToll());

        // Vehicle Count
        System.out.println("\n===== Vehicle Count =====");
        System.out.println("Cars   : " + carCount);
        System.out.println("Buses  : " + busCount);
        System.out.println("Trucks : " + truckCount);
    }
}