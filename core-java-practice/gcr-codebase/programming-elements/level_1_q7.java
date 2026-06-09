public class Main {
    public static void main(String[] args) {
        double radiusKm = 6378;

        // Volume of a sphere = (4/3) * π * r³
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

        // Convert cubic kilometers to cubic miles
        // 1 km = 0.621371 miles
        double volumeMiles3 = volumeKm3 * Math.pow(0.621371, 3);

        System.out.println("The volume of earth in cubic kilometers is " 
                           + volumeKm3 +
                           " and cubic miles is " 
                           + volumeMiles3);
    }
}