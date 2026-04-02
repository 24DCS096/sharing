import java.util.ArrayList;

public class ItemList {

    private static ItemList instance;
    private ArrayList<Item> items;

    private ItemList() {
        items = new ArrayList<>();
    }

    public static ItemList getInstance() {
        if (instance == null) {
            instance = new ItemList();
        }
        return instance;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getAvailableItems() {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.isAvailable()) {
                result.add(item);
            }
        }
        return result;
    }

    public ArrayList<Item> getBorrowedItems() {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (!item.isAvailable()) {
                result.add(item);
            }
        }
        return result;
    }
}
