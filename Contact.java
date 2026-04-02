public class Contact {

    private String username;
    private String email;
    private boolean isBorrower;

    public Contact(String username, String email) {
        this.username = username;
        this.email = email;
        this.isBorrower = false;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBorrower() {
        return isBorrower;
    }

    public void setBorrower(boolean borrower) {
        isBorrower = borrower;
    }
}
