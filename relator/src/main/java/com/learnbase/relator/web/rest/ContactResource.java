package com.learnbase.relator.web.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnbase.relator.domain.Contact;
import com.learnbase.relator.repository.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactResource {
	
	@Autowired
	private ContactRepository repository;
	
	@PostMapping("/create")
	public Contact createContact(@RequestBody Contact contact) {
		return this.repository.save(contact);
	}
	
	@PutMapping("/update")
	public Contact updateContact(@RequestBody Contact contact) {
		return contact.getId()!=null?this.repository.save(contact):null;
	}
	
	@GetMapping("/findAll")
	public List<Contact> getAllContacts() {
		return this.repository.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Contact getContactById(@PathVariable Long id) {
		Optional<Contact> contact = this.repository.findById(id);
		return contact.isPresent()?contact.get():null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteContact(@PathVariable Long id) {
		this.repository.deleteById(id);
	}
	

}
