class LibraryMember {
    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    double calculateFine(int overdueDays) {
        return 0;
    }

    void printDetails() {
        System.out.println("Member Name : " + memberName);
        System.out.println("Member ID   : " + memberId);
    }
}

class StudentMember extends LibraryMember {

    StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 2; // ₹2 per day
    }
}

class FacultyMember extends LibraryMember {

    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 1; // ₹1 per day
    }
}

class GuestMember extends LibraryMember {

    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 5; // ₹5 per day
    }
}

public class SmartLibraryMembership {

    public static void main(String[] args) {

        LibraryMember[] members = {
            new StudentMember("Lav", "S101"),
            new FacultyMember("Dr. Sharma", "F201"),
            new GuestMember("Rahul", "G301"),
            new StudentMember("Aman", "S102")
        };

        int overdueDays = 7;

        System.out.println("===== Library Members =====");

        for (LibraryMember m : members) {
            m.printDetails();

            // Dynamic Method Dispatch
            System.out.println("Fine for " + overdueDays +
                    " days = ₹" + m.calculateFine(overdueDays));

            System.out.println("-----------------------");
        }

        // Search Member by ID
        String searchId = "F201";
        boolean found = false;

        System.out.println("\nSearching Member ID: " + searchId);

        for (LibraryMember m : members) {
            if (m.memberId.equals(searchId)) {
                System.out.println("\nMember Found!");
                m.printDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Member not found.");
        }
    }
}