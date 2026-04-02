public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openContacts() {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}
