package com.illud.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illud.contact.model.Contact;
import com.illud.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	@Override
	public Optional<Contact> getContact(Long id) {
		return contactRepository.findById(id);
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}	

	@Override
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void deleteContact(Long id) {
		contactRepository.delete(contactRepository.getOne(id));
	}

}
