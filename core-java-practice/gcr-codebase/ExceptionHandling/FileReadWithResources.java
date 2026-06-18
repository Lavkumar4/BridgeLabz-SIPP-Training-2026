import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWithResources {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {

            String firstLine = br.readLine();
            System.out.println("First Line: " + firstLine);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}