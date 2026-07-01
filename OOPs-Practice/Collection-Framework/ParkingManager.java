import java.util.ArrayList;

public class ParkingManager {
    // ArrayList to store vehicle registration numbers
    private ArrayList<String> parkedVehicles = new ArrayList<>();

    // 1. Add vehicle (Enter)
    public void enterParking(String regNumber) {
        parkedVehicles.add(regNumber);
        System.out.println("Vehicle " + regNumber + " has entered the parking.");
    }

    // 2. Remove vehicle (Exit)
    public void exitParking(String regNumber) {
        if (parkedVehicles.remove(regNumber)) {
            System.out.println("Vehicle " + regNumber + " has exited the parking.");
        } else {
            System.out.println("Error: Vehicle " + regNumber + " not found in parking.");
        }
    }

    // 3. Search for a vehicle
    public void searchVehicle(String regNumber) {
        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Status: Vehicle " + regNumber + " is currently parked.");
        } else {
            System.out.println("Status: Vehicle " + regNumber + " is NOT in the parking.");
        }
    }

    // 4. Display all vehicles and occupied slots count
    public void displayOccupiedSlots() {
        System.out.println("\n--- Parked Vehicles List ---");
        if (parkedVehicles.isEmpty()) {
            System.out.println("The parking area is empty.");
        } else {
            for (String reg : parkedVehicles) {
                System.out.println("Slot occupied by: " + reg);
            }
            System.out.println("Total occupied slots: " + parkedVehicles.size());
        }
    }

    public static void main(String[] args) {
        ParkingManager mallParking = new ParkingManager();

        // Testing the features
        mallParking.enterParking("UP-32-1234");
        mallParking.enterParking("DL-01-9988");
        mallParking.enterParking("HR-26-5544");

        mallParking.displayOccupiedSlots();

        mallParking.searchVehicle("DL-01-9988");
        
        mallParking.exitParking("DL-01-9988");

        mallParking.displayOccupiedSlots();
    }
}