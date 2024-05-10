package com.cms.services;
import java.util.HashMap;
import java.util.Map;
import com.cms.models.Contact;

public class ContactService {
    private Map<Integer, Contact> contacts = new HashMap<>();
    private int nextContactId = 1;

    public Contact getContact(int contactId) {
        return contacts.get(contactId);
    }

    public Map<Integer, Contact> getAllContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contact.setId(nextContactId++);
        contacts.put(contact.getId(), contact);
    }

    public void updateContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) {
            contacts.put(contact.getId(), contact);
        } else {
        	throw new IllegalArgumentException("Contact with ID " + contact.getId() + " does not exist");
        }
    }

    public void deleteContact(int contactId) {
        contacts.remove(contactId);
    }
}
