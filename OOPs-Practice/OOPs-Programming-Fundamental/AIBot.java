class InterviewBot {

    // Instance Variables
    String botName;
    String technology;

    // Constructor
    InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    // Method
    void conductInterview() {
        System.out.println(botName +
                " is conducting a " +
                technology + " interview.");
    }
}

public class AIBot {
    public static void main(String[] args) {

        // Creating 3 bots
        InterviewBot bot1 =
                new InterviewBot("JavaBot", "Java");

        InterviewBot bot2 =
                new InterviewBot("PythonBot", "Python");

        InterviewBot bot3 =
                new InterviewBot("WebBot", "Web Development");

        // Conduct Interviews
        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}