package com.illud.contact.service;

import java.util.List;
import java.util.Optional;

import com.illud.contact.model.Contact;


public interface ContactService {
	
	Contact createContact(Contact contact);
	
	Optional<Contact> getContact(Long id); 
	
	List<Contact> getAllContacts();
	
	Contact updateContact(Contact contact);
	
	void deleteContact(Long id);
}
