package hr.danko.model;

import java.util.List;

public interface ContactDAO {
    public void saveOrUpdateContact(Contact contact);
    public void deleteContact(int id);
    public Contact getContact(int id);
    public List<Contact> getAllContacts();

}
