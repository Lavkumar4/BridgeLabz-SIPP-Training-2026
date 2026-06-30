import java.util.*;

class Astronaut {
    private String astronautId;
    private String name;
    private String specialization;

    public Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return name + " (" + specialization + ")";
    }
}

class MissionManager {
    // Mission Name -> List of Crew
    private HashMap<String, List<Astronaut>> missionCrewMap = new HashMap<>();
    
    // Duplicate check: Mission Name -> Set of Astronaut IDs
    private HashMap<String, HashSet<String>> missionAttendance = new HashMap<>();

    // 1. Add new mission
    public void addMission(String missionName) {
        missionCrewMap.putIfAbsent(missionName, new ArrayList<>());
        missionAttendance.putIfAbsent(missionName, new HashSet<>());
        System.out.println("🚀 Mission '" + missionName + "' initialized.");
    }

    // 2. Assign Astronaut (with Duplicate Check)
    public void assignAstronaut(String missionName, Astronaut astro) {
        if (!missionCrewMap.containsKey(missionName)) {
            System.out.println("❌ Error: Mission '" + missionName + "' not found!");
            return;
        }

        HashSet<String> assignedIds = missionAttendance.get(missionName);
        
        // 3. Prevent duplicate assignment using HashSet check
        if (assignedIds.contains(astro.toString())) {
            System.out.println("⚠️ Warning: " + astro + " is already assigned to " + missionName);
        } else {
            missionCrewMap.get(missionName).add(astro);
            assignedIds.add(astro.toString());
            System.out.println("✅ " + astro + " assigned to " + missionName);
        }
    }

    // 4 & 5. Display all missions and crew count
    public void displayAllMissions() {
        System.out.println("\n--- Current Space Mission Report ---");
        for (String mission : missionCrewMap.keySet()) {
            List<Astronaut> crew = missionCrewMap.get(mission);
            System.out.println("Mission: " + mission);
            System.out.println("Crew Members: " + crew);
            System.out.println("Total Crew Size: " + crew.size());
            System.out.println("------------------------------------");
        }
    }
}

public class SpaceAgencySystem {
    public static void main(String[] args) {
        MissionManager agency = new MissionManager();

        // Initialize missions
        agency.addMission("Mars Rover Alpha");
        agency.addMission("Lunar Base One");

        // Create astronauts
        Astronaut a1 = new Astronaut("A01", "Neil", "Pilot");
        Astronaut a2 = new Astronaut("A02", "Buzz", "Engineer");

        // Assigning
        agency.assignAstronaut("Mars Rover Alpha", a1);
        agency.assignAstronaut("Mars Rover Alpha", a2);
        agency.assignAstronaut("Mars Rover Alpha", a1); // Duplicate attempt

        // Display
        agency.displayAllMissions();
    }
}