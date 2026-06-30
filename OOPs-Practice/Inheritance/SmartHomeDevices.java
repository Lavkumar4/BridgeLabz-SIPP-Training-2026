// Superclass
class Device {
    String deviceId;
    String status;

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

// Subclass
class Thermostat extends Device {
    double temperatureSetting;

    // Constructor
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Method to display device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main Class
public class SmartHomeDevices {
    public static void main(String[] args) {

        Thermostat thermostat =
                new Thermostat("TH101", "ON", 24.5);

        thermostat.displayStatus();
    }
}