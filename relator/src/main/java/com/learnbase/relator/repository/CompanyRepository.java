package com.learnbase.relator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnbase.relator.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
