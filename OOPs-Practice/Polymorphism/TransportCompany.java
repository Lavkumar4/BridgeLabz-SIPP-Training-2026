class Vehicle {
    public double fuelCost(double km) {
        return 0;
    }
}

class Car extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 8; // ₹8 per km
    }
}

class Bus extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 15; // ₹15 per km
    }
}

class Bike extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 3; // ₹3 per km
    }
}

// New class added without modifying existing code
class ElectricCar extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 2; // ₹2 per km
    }
}

public class TransportCompany {
    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car(),
                new Bus(),
                new Bike(),
                new ElectricCar()
        };

        double km = 100;

        for (Vehicle v : fleet) {

            System.out.println("Fuel Cost for 100 km = ₹" + v.fuelCost(km));

            if (v instanceof Car) {
                System.out.println("Type: Car");
            } else if (v instanceof Bus) {
                System.out.println("Type: Bus");
            } else if (v instanceof Bike) {
                System.out.println("Type: Bike");
            } else if (v instanceof ElectricCar) {
                System.out.println("Type: Electric Car");
            }

            System.out.println("--------------------");
        }
    }
}