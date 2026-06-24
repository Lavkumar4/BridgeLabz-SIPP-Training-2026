// Abstract Class
abstract class LibraryItem {

    // Private Fields (Encapsulation)
    private int itemId;
    private String title;
    private String author;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Abstract Method
    public abstract int getLoanDuration();

    // Concrete Method
    public void displayItemDetails() {
        System.out.println("Item ID : " + itemId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
    }
}

// Book Class
class Book extends LibraryItem {

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }
}

// Magazine Class
class Magazine extends LibraryItem {

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }
}

// DVD Class
class DVD extends LibraryItem {

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }
}

// Main Class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Book book = new Book(101, "Java Programming", "James Gosling");
        Magazine magazine = new Magazine(201, "Tech Today", "Editorial Team");
        DVD dvd = new DVD(301, "Avengers Endgame", "Marvel Studios");

        System.out.println("===== Book Details =====");
        book.displayItemDetails();
        System.out.println("Loan Duration : "
                + book.getLoanDuration() + " days");

        System.out.println();

        System.out.println("===== Magazine Details =====");
        magazine.displayItemDetails();
        System.out.println("Loan Duration : "
                + magazine.getLoanDuration() + " days");

        System.out.println();

        System.out.println("===== DVD Details =====");
        dvd.displayItemDetails();
        System.out.println("Loan Duration : "
                + dvd.getLoanDuration() + " days");
    }
}