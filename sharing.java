import java.util.ArrayList;

/* =========================
   CONTACT CLASS
========================= */
class Contact {
    private String username;
    private String email;
    private boolean isBorrower;

    public Contact(String username, String email) {
        this.username = username;
        this.email = email;
        this.isBorrower = false;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBorrower() { return isBorrower; }

    public void setBorrower(boolean status) {
        this.isBorrower = status;
    }
}

/* =========================
   DIMENSIONS CLASS
========================= */
class Dimensions {
    private String width, height, length;

    public Dimensions(String w, String h, String l) {
        width = w;
        height = h;
        length = l;
    }
}

/* =========================
   ITEM CLASS
========================= */
class Item {
    private String name;
    private boolean available;
    private Contact borrower;
    private Dimensions dimensions;

    public Item(String name, Dimensions dimensions) {
        this.name = name;
        this.dimensions = dimensions;
        this.available = true;
    }

    public void borrow(Contact contact) {
        this.available = false;
        this.borrower = contact;
        contact.setBorrower(true);
    }

    public void returnItem() {
        this.available = true;
        if (borrower != null) borrower.setBorrower(false);
        borrower = null;
    }

    public boolean isAvailable() {
        return available;
    }
}

/* =========================
   ITEM LIST (AGGREGATION)
========================= */
class ItemList {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getAvailableItems() {
        ArrayList<Item> result = new ArrayList<>();
        for (Item i : items) {
            if (i.isAvailable()) result.add(i);
        }
        return result;
    }
}

/* =========================
   MAIN PROGRAM
========================= */
public class Sharing {

    public static void main(String[] args) {

        // Create contacts
        Contact c1 = new Contact("john", "john@email.com");
        Contact c2 = new Contact("anna", "anna@email.com");

        // Create item
        Dimensions d = new Dimensions("10", "20", "30");
        Item item = new Item("Laptop", d);

        // Borrow item
        item.borrow(c1);

        System.out.println("Item borrowed by: " + c1.getUsername());
    }
}
