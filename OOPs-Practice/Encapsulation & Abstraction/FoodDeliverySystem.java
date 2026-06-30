// Abstract Class
abstract class FoodItem {

    // Private Fields
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Abstract Method
    public abstract double calculateTotalPrice();

    // Concrete Method
    public void displayItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
        System.out.println("Quantity  : " + quantity);
    }
}

// VegItem Class
class VegItem extends FoodItem {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

// NonVegItem Class
class NonVegItem extends FoodItem {

    private double serviceCharge;

    public NonVegItem(String itemName, double price,
                      int quantity, double serviceCharge) {
        super(itemName, price, quantity);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}

// Main Class
public class FoodDeliverySystem {

    public static void main(String[] args) {

        VegItem veg = new VegItem(
                "Paneer Pizza", 250, 2);

        NonVegItem nonVeg = new NonVegItem(
                "Chicken Burger", 180, 3, 50);

        System.out.println("===== Veg Item =====");
        veg.displayItemDetails();
        System.out.println("Total Price : ₹"
                + veg.calculateTotalPrice());

        System.out.println();

        System.out.println("===== Non-Veg Item =====");
        nonVeg.displayItemDetails();
        System.out.println("Service Charge : ₹"
                + nonVeg.getServiceCharge());
        System.out.println("Total Price : ₹"
                + nonVeg.calculateTotalPrice());
    }
}