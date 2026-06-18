import java.util.Scanner;

public class ArrayExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize array
        int[] arr = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter index: ");
            int index = sc.nextInt();

            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }

        sc.close();
    }
}