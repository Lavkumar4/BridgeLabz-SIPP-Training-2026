import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

// 1. Contact class to represent each contact
class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
    }
}

// 2. AddressBook class containing the framework logic
class AddressBook {
    // Ordered storage for all contacts
    private ArrayList<Contact> contactList = new ArrayList<>();
    
    // Fast lookup by Name -> O(1)
    private HashMap<String, Contact> nameLookup = new HashMap<>();
    
    // Track unique phone numbers to avoid duplicates
    private HashSet<String> uniquePhones = new HashSet<>();

    // A. ADD CONTACT
    public boolean addContact(String name, String phone, String email) {
        // HashSet checks if phone already exists
        if (uniquePhones.contains(phone)) {
            System.out.println("❌ Error: Phone number '" + phone + "' already exists!");
            return false;
        }

        Contact newContact = new Contact(name, phone, email);
        
        contactList.add(newContact);          // Store in ArrayList
        nameLookup.put(name, newContact);     // Map for fast lookup
        uniquePhones.add(phone);             // Register phone in HashSet
        
        System.out.println("✅ Contact added successfully: " + name);
        return true;
    }

    // B. SEARCH CONTACT BY NAME -> O(1) Time Complexity
    public void searchByName(String name) {
        if (nameLookup.containsKey(name)) {
            System.out.println("🔍 Found: " + nameLookup.get(name));
        } else {
            System.out.println("❌ Contact not found with name: " + name);
        }
    }

    // C. DELETE CONTACT BY NAME
    public boolean deleteContact(String name) {
        if (!nameLookup.containsKey(name)) {
            System.out.println("❌ Cannot delete. Contact not found: " + name);
            return false;
        }

        // 1. Get the contact object to pull its phone number
        Contact contactToRemove = nameLookup.get(name);
        String phoneToRemove = contactToRemove.getPhone();

        // 2. Remove from all three structures
        nameLookup.remove(name);
        uniquePhones.remove(phoneToRemove);
        contactList.remove(contactToRemove);

        System.out.println("🗑️ Contact deleted successfully: " + name);
        return true;
    }

    // D. DISPLAY ALL CONTACTS (SORTED BY NAME)
    public void displaySorted() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is empty.");
            return;
        }

        // Collections.sort() uses a custom Comparator to sort by Name alphabetically
        Collections.sort(contactList, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareToIgnoreCase(c2.getName());
            }
        });

        System.out.println("\n--- Address Book (Sorted by Name) ---");
        for (Contact c : contactList) {
            System.out.println(c);
        }
        System.out.println("-------------------------------------");
    }
}

// 3. Main Class to test the application
public class Addres-Book-App-Store {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        // Adding contacts
        book.addContact("Rahul", "9876543210", "rahul@email.com");
        book.addContact("Amit", "8765432109", "amit@email.com");
        book.addContact("Zoya", "7654321098", "zoya@email.com");

        // Trying to add duplicate phone number
        book.addContact("Duplicate Amit", "9876543210", "amit2@email.com");

        // Display sorted
        book.displaySorted();

        // Search Lookup
        book.searchByName("Amit");

        // Delete Contact
        book.deleteContact("Amit");

        // Display sorted again to verify deletion
        book.displaySorted();
    }
}