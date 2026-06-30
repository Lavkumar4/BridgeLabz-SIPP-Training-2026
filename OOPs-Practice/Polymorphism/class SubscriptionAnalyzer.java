class Subscription {
    String subscriberName;
    String subscriptionId;

    Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    double calculateMonthlyCharge() {
        return 0;
    }

    void displayDetails() {
        System.out.println("Subscriber Name : " + subscriberName);
        System.out.println("Subscription ID : " + subscriptionId);
    }
}

class BasicPlan extends Subscription {

    BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 199;
    }
}

class PremiumPlan extends Subscription {

    PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 499;
    }
}

class FamilyPlan extends Subscription {

    FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 799;
    }
}

public class SubscriptionAnalyzer {

    // Search by Subscription ID
    static void searchById(Subscription[] subscriptions, String id) {

        for (Subscription s : subscriptions) {
            if (s.subscriptionId.equals(id)) {
                System.out.println("\nSubscription Found!");
                s.displayDetails();
                System.out.println("Monthly Charge : ₹" +
                        s.calculateMonthlyCharge());
                return;
            }
        }

        System.out.println("\nSubscription ID not found.");
    }

    // Display names starting with a letter
    static void displaySubscribersByLetter(
            Subscription[] subscriptions, char letter) {

        System.out.println(
                "\nSubscribers starting with '" + letter + "' :");

        boolean found = false;

        for (Subscription s : subscriptions) {
            if (Character.toUpperCase(s.subscriberName.charAt(0))
                    == Character.toUpperCase(letter)) {

                System.out.println(s.subscriberName);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No subscriber found.");
        }
    }

    // Calculate Total Revenue
    static double calculateTotalRevenue(
            Subscription[] subscriptions) {

        double total = 0;

        for (Subscription s : subscriptions) {
            total += s.calculateMonthlyCharge();
        }

        return total;
    }

    public static void main(String[] args) {

        Subscription[] subscriptions = {
                new BasicPlan("Lav", "B101"),
                new PremiumPlan("Rahul", "P201"),
                new FamilyPlan("Aman", "F301"),
                new PremiumPlan("Ankit", "P202"),
                new BasicPlan("Rohit", "B102")
        };

        // Display all subscriptions
        System.out.println("===== Subscription Details =====");

        Subscription expensivePlan = subscriptions[0];

        for (Subscription s : subscriptions) {

            s.displayDetails();

            System.out.println("Monthly Charge : ₹" +
                    s.calculateMonthlyCharge());

            System.out.println("-----------------------");

            // Find most expensive subscription
            if (s.calculateMonthlyCharge() >
                    expensivePlan.calculateMonthlyCharge()) {

                expensivePlan = s;
            }
        }

        // Total Revenue
        System.out.println("\nTotal Monthly Revenue = ₹" +
                calculateTotalRevenue(subscriptions));

        // Search by ID
        searchById(subscriptions, "F301");

        // Names starting with letter
        displaySubscribersByLetter(subscriptions, 'A');

        // Most Expensive Subscription
        System.out.println(
                "\n===== Most Expensive Subscription =====");

        expensivePlan.displayDetails();

        System.out.println("Monthly Charge : ₹" +
                expensivePlan.calculateMonthlyCharge());
    }
}