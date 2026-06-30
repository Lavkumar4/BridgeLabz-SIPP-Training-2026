import java.util.ArrayList;
import java.util.Scanner;

class ParkingManager {
    // Requirements के अनुसार ArrayList का उपयोग
    private ArrayList<String> parkedVehicles = new ArrayList<>();

    // 1. Add Vehicle (Enter)
    public void enterVehicle(String regNumber) {
        parkedVehicles.add(regNumber);
        System.out.println("✅ Vehicle " + regNumber + " has entered the parking.");
    }

    // 2. Remove Vehicle (Exit)
    public void exitVehicle(String regNumber) {
        if (parkedVehicles.remove(regNumber)) {
            System.out.println("⬅️ Vehicle " + regNumber + " has exited the parking.");
        } else {
            System.out.println("❌ Error: Vehicle " + regNumber + " not found in parking.");
        }
    }

    // 3. Search Vehicle
    public void searchVehicle(String regNumber) {
        if (parkedVehicles.contains(regNumber)) {
            System.out.println("🔍 Vehicle " + regNumber + " is currently parked.");
        } else {
            System.out.println("🚫 Vehicle " + regNumber + " is not in the parking.");
        }
    }

    // 4. Display all and Count
    public void displayStatus() {
        System.out.println("\n--- Current Parking Status ---");
        if (parkedVehicles.isEmpty()) {
            System.out.println("Parking is currently empty.");
        } else {
            System.out.println("Vehicles parked: " + parkedVehicles);
            System.out.println("Total slots occupied: " + parkedVehicles.size());
        }
        System.out.println("------------------------------\n");
    }
}

public class SmartParkingSystem {
    public static void main(String[] args) {
        ParkingManager mallParking = new ParkingManager();
        
        // Testing the features
        mallParking.enterVehicle("UP-32-1234");
        mallParking.enterVehicle("DL-01-9988");
        mallParking.enterVehicle("HR-26-5544");
        
        mallParking.displayStatus();
        
        mallParking.searchVehicle("DL-01-9988");
        
        mallParking.exitVehicle("DL-01-9988");
        
        mallParking.displayStatus();
    }
}