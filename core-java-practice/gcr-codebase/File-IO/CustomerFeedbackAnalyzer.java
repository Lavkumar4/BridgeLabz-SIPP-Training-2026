import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int goodCount = 0;

        System.out.println("Enter 5 feedback messages:");

        for (int i = 1; i <= 5; i++) {
            String feedback = br.readLine();

            if (feedback.toLowerCase().contains("good")) {
                goodCount++;
            }
        }

        System.out.println("Good Feedback Count = " + goodCount);
    }
}