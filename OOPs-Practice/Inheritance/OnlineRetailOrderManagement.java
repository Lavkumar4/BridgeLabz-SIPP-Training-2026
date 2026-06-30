// Base Class
class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

// Intermediate Class
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

// Derived Class
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate,
                   String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }

    void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Main Class
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {

        Order o1 = new Order(101, "20-06-2026");

        ShippedOrder o2 = new ShippedOrder(
                102, "21-06-2026", "TRK12345");

        DeliveredOrder o3 = new DeliveredOrder(
                103, "22-06-2026",
                "TRK67890", "24-06-2026");

        System.out.println("Order 1 Status: " + o1.getOrderStatus());
        System.out.println("Order 2 Status: " + o2.getOrderStatus());

        System.out.println("\nDelivered Order Details:");
        o3.displayDetails();
    }
}