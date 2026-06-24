// Interface 1
interface StreamingService {

    void streamMovie();

    default void showSubscriptionDetails() {
        System.out.println("Streaming Service Subscription Active");
    }
}

// Interface 2
interface GamingService {

    void playGame();

    default void showSubscriptionDetails() {
        System.out.println("Gaming Service Subscription Active");
    }
}

// Class implementing both interfaces
class SmartTV implements StreamingService, GamingService {

    String[] movies = {
            "Avengers",
            "Interstellar",
            "Inception"
    };

    String[] games = {
            "FIFA",
            "Minecraft",
            "Need for Speed"
    };

    @Override
    public void streamMovie() {
        System.out.println("Streaming movies...");
    }

    @Override
    public void playGame() {
        System.out.println("Playing games...");
    }

    // Resolving default method conflict
    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayContent() {

        System.out.println("\nAvailable Movies:");
        for (String movie : movies) {
            System.out.println(movie);
        }

        System.out.println("\nAvailable Games:");
        for (String game : games) {
            System.out.println(game);
        }
    }
}

// Main Class
public class SmartTVDemo {

    public static void main(String[] args) {

        SmartTV tv = new SmartTV();

        tv.streamMovie();
        tv.playGame();

        System.out.println("\nSubscription Details:");
        tv.showSubscriptionDetails();

        tv.displayContent();
    }
}