// Interface
interface Worker {
    void performDuties();
}

// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Subclass 1
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef prepares and cooks food.");
    }
}

// Subclass 2
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter takes orders and serves customers.");
    }
}

// Main Class
public class RestaurantManagementSystem {
    public static void main(String[] args) {

        Chef chef = new Chef("Rahul", 101);
        Waiter waiter = new Waiter("Amit", 102);

        System.out.println("Chef Details");
        chef.displayInfo();
        chef.performDuties();

        System.out.println();

        System.out.println("Waiter Details");
        waiter.displayInfo();
        waiter.performDuties();
    }
}