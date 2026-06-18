import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class EmailDomainCounter {
    public static void main(String[] args) {

        HashMap<String, Integer> domainCount = new HashMap<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader("emails.txt"))) {

            String email;

            while ((email = br.readLine()) != null) {

                int atIndex = email.indexOf('@');

                if (atIndex != -1) {
                    String domain = email.substring(atIndex + 1);

                    domainCount.put(
                            domain,
                            domainCount.getOrDefault(domain, 0) + 1
                    );
                }
            }

            System.out.println("Domain Counts:");
            for (String domain : domainCount.keySet()) {
                System.out.println(domain + " = "
                        + domainCount.get(domain));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}