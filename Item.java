public class Item {

    private String name;
    private boolean available;
    private Contact borrower;
    private Dimensions dimensions;

    public Item(String name, Dimensions dimensions) {
        this.name = name;
        this.dimensions = dimensions;
        this.available = true;
    }

    public void borrowItem(Contact contact) {
        this.available = false;
        this.borrower = contact;
        contact.setBorrower(true);
    }

    public void returnItem() {
        this.available = true;
        if (borrower != null) {
            borrower.setBorrower(false);
        }
        borrower = null;
    }

    public boolean isAvailable() {
        return available;
    }
}
