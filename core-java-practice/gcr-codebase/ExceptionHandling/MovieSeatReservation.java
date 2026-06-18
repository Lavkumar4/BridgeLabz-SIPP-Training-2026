public class MovieSeatReservation {

    static int[] seats = {101, 102, 103, 104, 105};

    public static int getSeat(int index) {
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid seat position requested.");
            return -1;
        }
    }

    public static void main(String[] args) {

        int seatNumber = getSeat(8);

        if (seatNumber != -1) {
            System.out.println("Booked Seat Number: " + seatNumber);
        } else {
            System.out.println("Seat booking failed.");
        }
    }
}