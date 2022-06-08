public interface IContactList {
    public boolean addNewContact(Contact contact);
    public boolean updateContact(Contact oldContact, Contact newContact);
    public boolean removeContact(Contact contact);
    public int findContact(Contact contact);
    public int findContact(String contactName);
    public String queryContact(Contact contact);
    public Contact queryContact(String name);
    public void printContacts();
}
