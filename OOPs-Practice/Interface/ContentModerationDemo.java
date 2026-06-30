// Interface 1
interface TextModeration {

    void checkText(String post);

    default void displayModerationPolicy() {
        System.out.println("Text Moderation Policy: No abusive or offensive language allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"hate", "abuse", "fake"};

        for (String word : restrictedWords) {
            if (post.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}

// Interface 2
interface SpamDetection {

    void detectSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam Detection Policy: No spam or promotional content allowed.");
    }
}

// Implementing Class
class ContentModerator implements TextModeration, SpamDetection {

    @Override
    public void checkText(String post) {
        if (TextModeration.containsRestrictedWords(post)) {
            System.out.println("Text Moderation Result: Inappropriate Content Detected");
        } else {
            System.out.println("Text Moderation Result: Content Approved");
        }
    }

    @Override
    public void detectSpam(String post) {
        if (post.toLowerCase().contains("buy now")
                || post.toLowerCase().contains("click here")) {
            System.out.println("Spam Detection Result: Spam Detected");
        } else {
            System.out.println("Spam Detection Result: No Spam Found");
        }
    }

    // Resolving default method conflict
    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }
}

// Main Class
public class ContentModerationDemo {

    public static void main(String[] args) {

        String[] posts = {
                "Welcome to our community!",
                "Buy now and get 50% discount!",
                "I hate this platform.",
                "Click here to win a prize!",
                "Have a great day everyone."
        };

        ContentModerator moderator = new ContentModerator();

        System.out.println("=== Moderation Policies ===");
        moderator.displayModerationPolicy();

        System.out.println("\n=== Post Analysis ===");

        for (String post : posts) {

            System.out.println("\nPost: " + post);

            moderator.checkText(post);
            moderator.detectSpam(post);
        }
    }
}