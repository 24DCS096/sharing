import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        contacts = new ArrayList<>();
    }

    public void addContact(String username, String email) {
        contacts.add(new Contact(username, email));
    }

    public void deleteContact(Contact contact) {
        if (!contact.isBorrower()) {
            contacts.remove(contact);
        }
    }
}
