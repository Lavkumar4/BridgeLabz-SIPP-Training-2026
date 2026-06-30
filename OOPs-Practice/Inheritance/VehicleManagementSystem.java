// Interface
interface Refuelable {
    void refuel();
}

// Superclass
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Subclass 1
class ElectricVehicle extends Vehicle {

    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    void charge() {
        System.out.println(model + " is charging...");
    }
}

// Subclass 2
class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is being refueled...");
    }
}

// Main Class
public class VehicleManagementSystem {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 225);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180);

        System.out.println("Electric Vehicle Details");
        ev.displayVehicleInfo();
        ev.charge();

        System.out.println("\nPetrol Vehicle Details");
        pv.displayVehicleInfo();
        pv.refuel();
    }
}