// Interface 1
interface Trackable {
    void logActivity();

    // Default method
    default void resetData() {
        System.out.println("Fitness data has been reset.");
    }
}

// Interface 2
interface Reportable {
    void generateReport();
}

// Interface 3
interface Notifiable {
    void sendAlert();
}

// Class implementing multiple interfaces
class FitnessDevice implements Trackable, Reportable, Notifiable {

    @Override
    public void logActivity() {
        System.out.println("Activity Logged: 5000 steps walked.");
    }

    @Override
    public void generateReport() {
        System.out.println("Report Generated: Calories Burned = 350");
    }

    @Override
    public void sendAlert() {
        System.out.println("Alert: Daily goal not completed!");
    }
}

// Main Class
public class FitnessTrackerDemo {
    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();

        // Calling default method
        device.resetData();
    }
}