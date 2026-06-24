// Interface 1
interface FoodDelivery {

    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("Tracking Food Order...");
    }

    // Static Method
    static String generateDeliveryCode() {
        return "FD" + (int)(Math.random() * 1000);
    }
}

// Interface 2
interface GroceryDelivery {

    void deliverGroceries(String customerName);

    default void trackOrder() {
        System.out.println("Tracking Grocery Order...");
    }
}

// Implementing Class
class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    @Override
    public void deliverFood(String customerName) {
        System.out.println("Food delivered to " + customerName);
    }

    @Override
    public void deliverGroceries(String customerName) {
        System.out.println("Groceries delivered to " + customerName);
    }

    // Resolving default method conflict
    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public void processDelivery(String customerName) {

        String code = FoodDelivery.generateDeliveryCode();

        System.out.println("\nCustomer: " + customerName);
        System.out.println("Delivery Code: " + code);

        trackOrder();

        deliverFood(customerName);
        deliverGroceries(customerName);

        System.out.println("Delivery Completed");
    }
}

// Main Class
public class DeliverySystemDemo {

    public static void main(String[] args) {

        String[] customers = {
                "Rahul",
                "Priya",
                "Aman",
                "Sneha"
        };

        DeliveryExecutive executive = new DeliveryExecutive();

        System.out.println("===== DELIVERY REPORT =====");

        for (String customer : customers) {
            executive.processDelivery(customer);
        }
    }
}