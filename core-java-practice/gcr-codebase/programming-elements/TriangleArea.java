import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double base = input.nextDouble();
        double height = input.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaInch = areaCm / 6.4516; // 1 square inch = 6.4516 square cm

        System.out.println("The area of the triangle in square centimeters is "
                + areaCm + " and in square inches is " + areaInch);

        input.close();
    }
}