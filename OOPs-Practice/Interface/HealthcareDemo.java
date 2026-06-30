// Interface 1
interface HeartRateMonitor {

    void monitorHeartRate(int heartRate);

    default void displayHealthTips() {
        System.out.println("Heart Health Tip: Exercise regularly and avoid stress.");
    }
}

// Interface 2
interface TemperatureMonitor {

    void monitorTemperature(double temperature);

    default void displayHealthTips() {
        System.out.println("Temperature Health Tip: Stay hydrated and rest properly.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId.startsWith("P") && patientId.length() == 5;
    }
}

// Implementing Class
class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    @Override
    public void monitorHeartRate(int heartRate) {
        System.out.println("Heart Rate: " + heartRate + " bpm");
    }

    @Override
    public void monitorTemperature(double temperature) {
        System.out.println("Temperature: " + temperature + " °C");
    }

    // Resolve default method conflict
    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    // Generate Health Report
    public void generateHealthReport(String name, String patientId,
                                     int heartRate, double temperature) {

        System.out.println("\nPatient Name : " + name);
        System.out.println("Patient ID   : " + patientId);

        if (TemperatureMonitor.isPatientIdValid(patientId)) {
            System.out.println("ID Status    : Valid");
        } else {
            System.out.println("ID Status    : Invalid");
        }

        monitorHeartRate(heartRate);
        monitorTemperature(temperature);

        String status = "Healthy";

        if (heartRate < 60 || heartRate > 100 ||
                temperature < 36.5 || temperature > 37.5) {
            status = "Needs Medical Attention";
        }

        System.out.println("Health Status: " + status);
    }
}

// Main Class
public class HealthcareDemo {

    public static void main(String[] args) {

        String[] patientNames = {
                "Rahul",
                "Priya",
                "Aman",
                "Sneha"
        };

        String[] patientIds = {
                "P1001",
                "P1002",
                "X2003",
                "P1004"
        };

        int[] heartRates = {
                72,
                105,
                85,
                58
        };

        double[] temperatures = {
                36.8,
                38.2,
                37.0,
                36.4
        };

        HealthMonitoringSystem system = new HealthMonitoringSystem();

        System.out.println("===== HEALTH TIPS =====");
        system.displayHealthTips();

        System.out.println("\n===== FINAL HEALTH REPORT =====");

        for (int i = 0; i < patientNames.length; i++) {

            system.generateHealthReport(
                    patientNames[i],
                    patientIds[i],
                    heartRates[i],
                    temperatures[i]
            );
        }
    }
}