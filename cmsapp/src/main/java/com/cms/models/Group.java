package com.cms.models;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<Contact> contacts;

    public Group() {
        // Default constructor
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", name=" + name + ", contacts=" + contacts + "]";
    }
}
