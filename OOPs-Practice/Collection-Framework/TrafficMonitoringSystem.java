import java.util.*;

class TrafficManager {
    // HashMap for fast storage and updates
    private HashMap<String, Integer> trafficMap = new HashMap<>();

    // 1. Add or Update vehicle counts
    public void updateTraffic(String roadName, int vehicleCount) {
        // .put() method naya value daal deta hai ya purane ko update kar deta hai
        trafficMap.put(roadName, trafficMap.getOrDefault(roadName, 0) + vehicleCount);
        System.out.println("✅ Updated " + roadName + ": " + vehicleCount + " vehicles added.");
    }

    // 2. Display all roads in sorted order (using TreeMap)
    public void displaySortedTraffic() {
        System.out.println("\n--- Traffic Report (Sorted by Road Name) ---");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(trafficMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Road: " + entry.getKey() + " | Vehicles: " + entry.getValue());
        }
    }

    // 3. Identify the busiest road
    public void identifyBusiestRoad() {
        if (trafficMap.isEmpty()) {
            System.out.println("No traffic data available.");
            return;
        }

        String busiestRoad = Collections.max(trafficMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\n🔥 Busiest Road: " + busiestRoad + " (Traffic: " + trafficMap.get(busiestRoad) + ")");
    }

    // 4 & 5. Generate Report and Total count
    public void generateReport() {
        System.out.println("\n--- Comprehensive Traffic Analysis ---");
        System.out.println("Total roads monitored: " + trafficMap.size());
        trafficMap.forEach((road, count) -> {
            String status = (count > 500) ? "Heavy Traffic" : "Normal Flow";
            System.out.println(road + ": " + count + " [" + status + "]");
        });
    }
}

public class TrafficMonitoringSystem {
    public static void main(String[] args) {
        TrafficManager cityTraffic = new TrafficManager();

        cityTraffic.updateTraffic("MG Road", 600);
        cityTraffic.updateTraffic("Link Road", 200);
        cityTraffic.updateTraffic("Airport Highway", 850);
        cityTraffic.updateTraffic("MG Road", 50); // Updating existing road

        cityTraffic.displaySortedTraffic();
        cityTraffic.identifyBusiestRoad();
        cityTraffic.generateReport();
    }
}