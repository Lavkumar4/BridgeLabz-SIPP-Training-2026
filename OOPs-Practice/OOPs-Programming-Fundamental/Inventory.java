class Item {
    String itemCode;
    String itemName;
    double price;

    // Constructor
    Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to calculate total cost
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Method to display item details
    void displayDetails(int quantity) {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Item: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + calculateTotalCost(quantity));
    }
}

public class Inventory {
    public static void main(String[] args) {
        Item item = new Item("I101", "Laptop", 50000);

        item.displayDetails(2);
    }
}