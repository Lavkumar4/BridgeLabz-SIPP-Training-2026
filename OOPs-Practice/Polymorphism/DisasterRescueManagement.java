class RescueTeam {
    String teamId;
    String location;

    RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    void performDuty() {
        System.out.println("Rescue Team is performing duty.");
    }

    void displayDetails() {
        System.out.println("Team ID  : " + teamId);
        System.out.println("Location : " + location);
    }
}

// Medical Team
class MedicalTeam extends RescueTeam {

    MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    void performDuty() {
        System.out.println("Medical Team is providing medical aid.");
    }
}

// Fire Rescue Team
class FireRescueTeam extends RescueTeam {

    FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    void performDuty() {
        System.out.println("Fire Rescue Team is controlling fire and saving lives.");
    }
}

// Food Supply Team
class FoodSupplyTeam extends RescueTeam {

    FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    void performDuty() {
        System.out.println("Food Supply Team is distributing food and water.");
    }
}

public class DisasterRescueManagement {

    // Find team by location
    static void findTeamByLocation(RescueTeam[] teams, String location) {

        boolean found = false;

        System.out.println("\nTeams deployed at " + location + ":");

        for (RescueTeam team : teams) {
            if (team.location.equalsIgnoreCase(location)) {
                team.displayDetails();
                System.out.println("-------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No team found at this location.");
        }
    }

    // Display teams by location prefix
    static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {

        boolean found = false;

        System.out.println("\nTeams whose location starts with \"" + prefix + "\"");

        for (RescueTeam team : teams) {
            if (team.location.toLowerCase()
                    .startsWith(prefix.toLowerCase())) {

                team.displayDetails();
                System.out.println("-------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching teams found.");
        }
    }

    public static void main(String[] args) {

        RescueTeam[] teams = {
                new MedicalTeam("M101", "Delhi"),
                new FireRescueTeam("F201", "Noida"),
                new FoodSupplyTeam("FS301", "Delhi"),
                new MedicalTeam("M102", "Lucknow"),
                new FireRescueTeam("F202", "Delhi"),
                new FoodSupplyTeam("FS302", "Noida")
        };

        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        System.out.println("===== Rescue Operations =====");

        for (RescueTeam team : teams) {

            team.displayDetails();

            // Runtime Polymorphism
            team.performDuty();

            System.out.println("-------------------");

            if (team instanceof MedicalTeam)
                medicalCount++;
            else if (team instanceof FireRescueTeam)
                fireCount++;
            else if (team instanceof FoodSupplyTeam)
                foodCount++;
        }

        // Search by Location
        findTeamByLocation(teams, "Delhi");

        // Search by Prefix
        displayTeamsByPrefix(teams, "D");

        // Count Teams
        System.out.println("\n===== Deployment Count =====");
        System.out.println("Medical Teams     : " + medicalCount);
        System.out.println("Fire Rescue Teams : " + fireCount);
        System.out.println("Food Supply Teams : " + foodCount);

        // Maximum Deployment Category
        System.out.println("\n===== Maximum Deployment Category =====");

        if (medicalCount >= fireCount && medicalCount >= foodCount)
            System.out.println("Medical Team has maximum deployments.");
        else if (fireCount >= medicalCount && fireCount >= foodCount)
            System.out.println("Fire Rescue Team has maximum deployments.");
        else
            System.out.println("Food Supply Team has maximum deployments.");
    }
}