class Circle {
    double radius;

    // Default Constructor
    Circle() {
        this(1.0);   // Calls parameterized constructor
        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructor
    Circle(double radius) {
        this.radius = radius;
        System.out.println("Parameterized Constructor Called");
    }

    // Method to display radius
    void display() {
        System.out.println("Radius = " + radius);
    }
}

public class CircleRadius {
    public static void main(String[] args) {

        Circle c1 = new Circle();
        c1.display();

        System.out.println();

        Circle c2 = new Circle(5.0);
        c2.display();
    }
}