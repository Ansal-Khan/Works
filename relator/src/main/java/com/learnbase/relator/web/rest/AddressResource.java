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

import com.learnbase.relator.domain.Address;
import com.learnbase.relator.repository.AddressRepository;

@RestController
@RequestMapping("/address")
public class AddressResource {
	
	@Autowired
	private AddressRepository repository;
	
	@PostMapping("/create")
	public Address createAddress(@RequestBody Address address) {
		return this.repository.save(address);
	}
	
	@PutMapping("/update")
	public Address updateAddress(@RequestBody Address address) {
		return this.getAddressById(address.getId())!=null?this.repository.save(address):null;
	}
	
	@GetMapping("/findAll")
	public List<Address> getAllAddresss() {
		return this.repository.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Address getAddressById(@PathVariable Long id) {
		Optional<Address> address = this.repository.findById(id);
		return address.isPresent()?address.get():null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAddress(@PathVariable Long id) {
		this.repository.deleteById(id);
	}
	

}
