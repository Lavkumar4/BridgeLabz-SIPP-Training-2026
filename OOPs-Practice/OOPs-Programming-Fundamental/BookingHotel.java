class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default Constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized Constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    HotelBooking(HotelBooking h) {
        this.guestName = h.guestName;
        this.roomType = h.roomType;
        this.nights = h.nights;
    }

    // Display Booking Details
    void displayDetails() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
        System.out.println();
    }
}

public class BookingHotel {
    public static void main(String[] args) {

        // Using Default Constructor
        HotelBooking booking1 = new HotelBooking();

        // Using Parameterized Constructor
        HotelBooking booking2 =
                new HotelBooking("Lav", "Deluxe", 3);

        // Using Copy Constructor
        HotelBooking booking3 =
                new HotelBooking(booking2);

        System.out.println("Booking 1 (Default Constructor)");
        booking1.displayDetails();

        System.out.println("Booking 2 (Parameterized Constructor)");
        booking2.displayDetails();

        System.out.println("Booking 3 (Copy Constructor)");
        booking3.displayDetails();
    }
}