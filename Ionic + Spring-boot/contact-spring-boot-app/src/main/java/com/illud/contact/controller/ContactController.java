package com.illud.contact.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.illud.contact.model.Contact;
import com.illud.contact.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/api/new")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws URISyntaxException {
		log.debug("Rest POST request to create contact: {}",contact);
		Contact result = contactService.createContact(contact);
		return ResponseEntity.created(new URI("/api/new/"+result.getId()))
				.header("X-contact-created", result.toString())
				.body(result);
	}
	
	@GetMapping("/api/get/{id}")
	public ResponseEntity<Contact> readContact(@PathVariable Long id) {
		log.debug("REST request to GET Contact : {}", id);
		Optional<Contact> result = contactService.getContact(id);
		return ResponseEntity.of(result);
	}
	
	@GetMapping("/api/get")
	public ResponseEntity<List<Contact>> readAllContacts() {
		log.debug("REST request to GET all Contacts");
		List<Contact> result = contactService.getAllContacts();
		return ResponseEntity.ok()
				.body(result);
	}
	
	@PutMapping("/api/update")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) throws URISyntaxException {
		log.debug("REST PUT request to update Contact : {}", contact);
		if(contact.getId() != null)
		{
			Contact result = contactService.updateContact(contact);
			return ResponseEntity.ok()
		            .header("X-contact-updated", result.toString())
		            .body(result);
		}
		return ResponseEntity.badRequest()
				.body(null);
	}
	
	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
		log.debug("REST request to delete Contact : {}", id);
		contactService.deleteContact(id);
		return ResponseEntity.ok()
		.header("X-contact-deleted", id.toString())
		.build();
	}
}
