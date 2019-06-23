package com.learnbase.relator.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable= false)
	private String name;
	
	@OneToOne
	@JoinColumn(name="address_id")
	@JsonIgnoreProperties("person")
	private Address address;
	
	@OneToMany(mappedBy="person")
	@JsonIgnoreProperties("person")
	private Set<Contact> contacts;
	
	@ManyToMany
	@JoinTable(name = "person_company", 
		joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
	@JsonIgnoreProperties("persons")
	private Set<Company> companies;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public Set<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}	
}
