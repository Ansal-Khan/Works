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

import com.learnbase.relator.domain.Company;
import com.learnbase.relator.repository.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyResource {
	
	@Autowired
	private CompanyRepository repository;
	
	@PostMapping("/create")
	public Company createCompany(@RequestBody Company company) {
		return this.repository.save(company);
	}
	
	@PutMapping("/update")
	public Company updateCompany(@RequestBody Company company) {
		return company.getId()!=null?this.repository.save(company):null;
	}
	
	@GetMapping("/findAll")
	public List<Company> getAllCompanys() {
		return this.repository.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Company getCompanyById(@PathVariable Long id) {
		Optional<Company> company = this.repository.findById(id);
		return company.isPresent()?company.get():null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCompany(@PathVariable Long id) {
		this.repository.deleteById(id);
	}
	

}
