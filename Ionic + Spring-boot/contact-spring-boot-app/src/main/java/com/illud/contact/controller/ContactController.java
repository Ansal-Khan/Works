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

/**
 * This is a REST controller that handles all the CRUD operations
 * related to the 'contacts' entity.
 * 
 * 
 * @author Ansal Khan
 * @version 1.0
 * @since 2019-03-05
 *
 */

/**
 * Given Annotation @RestController to make the class a REST Controller.
 */
@RestController
public class ContactController {
	
	/**
	 * Autowired service reference of the contact domain (Interface ContactService).
	 * Used for  accessing the services defined in the ContactServiceImpl.
	 * Spring injects the Bean of  the implementer class 'ContactServiceImpl', since we've given the annotation @Service on that class.
	 */
	@Autowired
	ContactService contactService;
	
	/**
	 * SL4J logger used to enable logging of events and Rest calls.
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * Used to map POST requests for creating contacts.
	 * 
	 * @param contact Object of the model class Contact, to be saved.
	 * @return ResponseEntity<Contact> embedded with saved contact along with generated id field (contact.id)
	 * @throws URISyntaxException, possible when using new URI
	 */
	@PostMapping("/api/new")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws URISyntaxException {
		log.debug("Rest POST request to create contact: {}",contact);
		Contact result = contactService.createContact(contact);
		return ResponseEntity.created(new URI("/api/new/"+result.getId()))
				.header("X-contact-created", result.toString())
				.body(result);
	}
	
	/**
	 * Used to map GET request for an individual contact.
	 * 
	 * @param id, of the contact to be accessed. Accepts the id of the particular contact to be fetched, as a path variable.
	 * @return ResponseEntity<Contact> embedded with the fetched contact.
	 */
	@GetMapping("/api/get/{id}")
	public ResponseEntity<Contact> readContact(@PathVariable Long id) {
		log.debug("REST request to GET Contact : {}", id);
		Optional<Contact> result = contactService.getContact(id);
		return ResponseEntity.of(result);
	}
	
	/**
	 * Used to map GET request for the list of all contacts in the database.
	 * 
	 * @return ResponseEntity<List<Contact>> embedded with list of all of the contacts in database.
	 */
	@GetMapping("/api/get")
	public ResponseEntity<List<Contact>> readAllContacts() {
		log.debug("REST request to GET all Contacts");
		List<Contact> result = contactService.getAllContacts();
		return ResponseEntity.ok()
				.body(result);
	}
	
	/**
	 * Used to map PUT requests for editing a particular contact
	 * 
	 * @param contact, The contact to be updated, assumes that the object contains updated values.
	 * @return ResponseEntity<Contact> embedded with the updated contact.
	 * @throws URISyntaxException possible when creating a new URI.
	 */
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
	
	
	/** 
	 * Used to map DELETE requests, for deleting a contact entry from the database.
	 * 
	 * @param id, The id attribute of the contact intended to be deleted. Passed as a path variable.
	 * @return ResponseEntity<Void>  which wraps nothing. Howbeit, the required headers to show the request was successful is added.
	 */
	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
		log.debug("REST request to delete Contact : {}", id);
		contactService.deleteContact(id);
		return ResponseEntity.ok()
		.header("X-contact-deleted", id.toString())
		.build();
	}
}
