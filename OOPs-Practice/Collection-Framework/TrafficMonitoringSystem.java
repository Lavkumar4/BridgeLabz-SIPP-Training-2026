import java.util.*;

public class TrafficMonitoringSystem {
    // HashMap for efficient O(1) updates
    private Map<String, Integer> trafficData = new HashMap<>();

    // 1. Add or update vehicle counts
    public void updateTraffic(String roadName, int count) {
        trafficData.put(roadName, trafficData.getOrDefault(roadName, 0) + count);
        System.out.println("Updated " + roadName + ": " + trafficData.get(roadName) + " vehicles.");
    }

    // 2. Display roads in sorted order using TreeMap
    public void displaySortedReport() {
        TreeMap<String, Integer> sortedRoads = new TreeMap<>(trafficData);
        System.out.println("\n--- Traffic Report (Sorted by Road Name) ---");
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            System.out.println("Road: " + entry.getKey() + " | Vehicles: " + entry.getValue());
        }
    }

    // 3. Identify the busiest road
    public void identifyBusiestRoad() {
        if (trafficData.isEmpty()) {
            System.out.println("No traffic data available.");
            return;
        }

        String busiest = Collections.max(trafficData.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\nBusiest Road: " + busiest + " (" + trafficData.get(busiest) + " vehicles)");
    }

    // 4 & 5. Generate summary report
    public void generateSummary() {
        System.out.println("\n--- City Traffic Summary ---");
        System.out.println("Total roads monitored: " + trafficData.size());
        identifyBusiestRoad();
    }

    public static void main(String[] args) {
        TrafficMonitoringSystem tms = new TrafficMonitoringSystem();

        tms.updateTraffic("Main Street", 150);
        tms.updateTraffic("Broadway", 200);
        tms.updateTraffic("Park Avenue", 120);
        tms.updateTraffic("Broadway", 50); // Updates existing road

        tms.displaySortedReport();
        tms.generateSummary();
    }
}