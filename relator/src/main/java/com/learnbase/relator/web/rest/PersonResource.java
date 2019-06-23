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

import com.learnbase.relator.domain.Person;
import com.learnbase.relator.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonResource {
	
	@Autowired
	private PersonRepository repository;
	
	@PostMapping("/create")
	public Person createPerson(@RequestBody Person person) {
		return this.repository.save(person);
	}
	
	@PutMapping("/update")
	public Person updatePerson(@RequestBody Person person) {
		return person.getId()!=null?this.repository.save(person):null;
	}
	
	@GetMapping("/findAll")
	public List<Person> getAllPersons() {
		return this.repository.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Person getPersonById(@PathVariable Long id) {
		Optional<Person> person = this.repository.findById(id);
		return person.isPresent()?person.get():null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable Long id) {
		this.repository.deleteById(id);
	}
	

}
