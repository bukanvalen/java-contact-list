public class User {
    private int id;
    private String nama;
    private String username;
    private String password;
    private ContactList contactList;

    public User(int id, String nama, String username, String password, String phoneNumber) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.contactList = new ContactList(id, nama, phoneNumber);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public boolean checkUser(int id, String nama, String username) {
        if (getId() == id && getName().equals(nama) && getUsername().equals(username)) {
            return true;
        }
        return false;
    }

    public boolean checkPassword(String password) {
        if (getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
