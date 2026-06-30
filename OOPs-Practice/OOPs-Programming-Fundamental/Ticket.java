class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    // Constructor
    MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    // Method to book ticket
    void bookTicket(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    // Method to display ticket details
    void displayTicketDetails() {
        System.out.println("\n----- Ticket Details -----");
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price      : ₹" + price);
    }
}

public class Ticket {
    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket("Avengers: Endgame");

        ticket.bookTicket(12, 250.0);

        ticket.displayTicketDetails();
    }
}