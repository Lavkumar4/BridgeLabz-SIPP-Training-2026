class Book {
    String title;
    String author;
    double price;

    // Default Constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : ₹" + price);
        System.out.println();
    }
}

public class Book1 {
    public static void main(String[] args) {

        // Using Default Constructor
        Book b1 = new Book();

        // Using Parameterized Constructor
        Book b2 = new Book("Java Programming", "James Gosling", 599.99);

        System.out.println("Book 1 Details:");
        b1.displayDetails();

        System.out.println("Book 2 Details:");
        b2.displayDetails();
    }
}