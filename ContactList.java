import java.util.ArrayList;

public class ContactList implements IContactList {
    private ArrayList<Contact> contactList;

    public ContactList(int id, String name, String phoneNumber) {
        this.contactList = new ArrayList<Contact>();
        contactList.add(new Contact(id, name, phoneNumber));
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0)
            System.out.println("Kontak sudah ada!");
        contactList.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " tidak ditemukan!");
            return false;
        }

        this.contactList.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " telah digantikan dengan " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " tidak ditemukan");
            return false;
        }
        this.contactList.remove(foundPosition);
        System.out.println(contact.getName() + " telah dihapus");
        return true;
    }

    public int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < contactList.size(); i++) {

            Contact contacts = this.contactList.get(i);
            if (contacts.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.contactList.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("\n\t[ Contact List ]");
        System.out.println("---------------------------------");
        for (int i = 0; i < this.contactList.size(); i++) {
            System.out.println("| " + this.contactList.get(i).getId() + " = " +
                    this.contactList.get(i).getName() +
                    " -> " + this.contactList.get(i).getPhoneNumber() + " |");
        }
        System.out.println("---------------------------------");
    }

}