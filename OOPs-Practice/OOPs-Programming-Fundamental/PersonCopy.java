class Person {
    String name;
    int age;

    // Parameterized Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    // Method to display details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
    }
}

public class PersonCopy {
    public static void main(String[] args) {

        // Original Object
        Person p1 = new Person("Lav", 20);

        // Copy Object
        Person p2 = new Person(p1);

        System.out.println("Original Person:");
        p1.display();

        System.out.println("\nCopied Person:");
        p2.display();
    }
}