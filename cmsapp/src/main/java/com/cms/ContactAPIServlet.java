package com.cms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.models.Contact;
import com.cms.services.ContactService;

@WebServlet("/contacts")
public class ContactAPIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ContactService contactService = new ContactService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactIdParam = request.getParameter("id");
        
        if (contactIdParam != null) {
            int contactId = Integer.parseInt(contactIdParam);
            Contact contact = contactService.getContact(contactId);
            if (contact != null) {
                response.getWriter().write(contact.toString());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.getWriter().write(contactService.getAllContacts().toString());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phone_number");
        
        if (name != null && phoneNumber != null) {
            Contact newContact = new Contact();
            newContact.setName(name);
            newContact.setPhoneNumber(phoneNumber);
            contactService.addContact(newContact);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

