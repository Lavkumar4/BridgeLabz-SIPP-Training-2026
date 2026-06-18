public class SmartLibrarySystem {

    static String[] books = {"Java", "Python", null, "C++"};

    public static int getBookLength(int index) {

        try {
            return books[index].length();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid book index. Please enter an index between 0 and "
                    + (books.length - 1));
        } catch (NullPointerException e) {
            System.out.println("Error: Book entry is empty (null).");
        }

        return -1;
    }

    public static void main(String[] args) {

        // Valid Index
        System.out.println("Length: " + getBookLength(0));

        // Null Entry
        System.out.println("Length: " + getBookLength(2));

        // Invalid Index
        System.out.println("Length: " + getBookLength(5));
    }
}