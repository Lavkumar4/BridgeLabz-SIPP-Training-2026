import java.util.*;

// 1. Astronaut class definition
class Astronaut {
    String astronautId;
    String name;
    String specialization;

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

public class CrewManagementSystem {
    // Stores mission name and the list of crew members
    private Map<String, List<Astronaut>> missionMap = new HashMap<>();
    // Stores mission name and a set of IDs to prevent duplicates within that mission
    private Map<String, Set<String>> missionIdCheck = new HashMap<>();

    // Add a mission
    public void addMission(String missionName) {
        missionMap.putIfAbsent(missionName, new ArrayList<>());
        missionIdCheck.putIfAbsent(missionName, new HashSet<>());
    }

    // Assign astronaut to a mission
    public void assignAstronaut(String missionName, Astronaut astro) {
        if (!missionMap.containsKey(missionName)) {
            System.out.println("Mission " + missionName + " does not exist.");
            return;
        }

        Set<String> assignedIds = missionIdCheck.get(missionName);

        // Prevent duplicate assignment using HashSet
        if (assignedIds.add(astro.astronautId)) {
            missionMap.get(missionName).add(astro);
            System.out.println(astro.name + " assigned to " + missionName + ".");
        } else {
            System.out.println(astro.name + " is already assigned to " + missionName + "!");
        }
    }

    // Display all missions
    public void displayMissions() {
        System.out.println("\n--- Current Mission Crew Assignments ---");
        for (String mission : missionMap.keySet()) {
            List<Astronaut> crew = missionMap.get(mission);
            System.out.println("Mission: " + mission);
            System.out.println("Crew: " + crew);
            System.out.println("Total Crew Size: " + crew.size());
            System.out.println("----------------------------------------");
        }
    }

    public static void main(String[] args) {
        CrewManagementSystem cms = new CrewManagementSystem();
        
        cms.addMission("Mars Rover");
        
        Astronaut a1 = new Astronaut("A001", "Commander Shepard", "Pilot");
        Astronaut a2 = new Astronaut("A002", "Dr. Tali", "Engineer");

        cms.assignAstronaut("Mars Rover", a1);
        cms.assignAstronaut("Mars Rover", a2);
        cms.assignAstronaut("Mars Rover", a1); // Duplicate attempt
        
        cms.displayMissions();
    }
}