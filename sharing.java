import java.util.ArrayList;

// Contact Class
class Contact {
    String username;
    String email;
    boolean isBorrower;

    public Contact(String username, String email) {
        this.username = username;
        this.email = email;
        this.isBorrower = false;
    }
}

// Dimensions Class
class Dimensions {
    String width, height, length;

    public Dimensions(String w, String h, String l) {
        width = w;
        height = h;
        length = l;
    }
}

// Item Class
class Item {
    String name;
    boolean available;
    Contact borrower;
    Dimensions dimensions;

    public Item(String name, Dimensions d) {
        this.name = name;
        this.dimensions = d;
        this.available = true;
    }

    public void borrow(Contact c) {
        available = false;
        borrower = c;
        c.isBorrower = true;
    }

    public void returnItem() {
        if (borrower != null) {
            borrower.isBorrower = false;
        }
        borrower = null;
        available = true;
    }
}

// ItemList Class
class ItemList {
    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getAvailableItems() {
        ArrayList<Item> result = new ArrayList<>();
        for (Item i : items) {
            if (i.available) result.add(i);
        }
        return result;
    }

    public ArrayList<Item> getBorrowedItems() {
        ArrayList<Item> result = new ArrayList<>();
        for (Item i : items) {
            if (!i.available) result.add(i);
        }
        return result;
    }
}

// Main App Simulation
public class sharing {
    public static void main(String[] args) {

        Contact c1 = new Contact("john", "john@email.com");

        Dimensions d = new Dimensions("10", "5", "3");

        Item item = new Item("Laptop", d);

        ItemList list = new ItemList();
        list.addItem(item);

        item.borrow(c1);

        System.out.println(item.name + " borrowed by " + c1.username);
    }
}
