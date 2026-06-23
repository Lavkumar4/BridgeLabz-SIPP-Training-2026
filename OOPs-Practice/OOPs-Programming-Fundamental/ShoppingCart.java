class CartItem {
    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    // Add item to cart
    void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " " + itemName + "(s) added to cart.");
    }

    // Remove item from cart
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " " + itemName + "(s) removed from cart.");
        } else {
            System.out.println("Cannot remove more items than available in cart.");
        }
    }

    // Display total cost
    void displayTotalCost() {
        double totalCost = price * quantity;

        System.out.println("\n----- Cart Details -----");
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total Cost: ₹" + totalCost);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {

        CartItem item = new CartItem("Laptop", 50000);

        item.addItem(2);
        item.removeItem(1);

        item.displayTotalCost();
    }
}