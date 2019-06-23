package com.learnbase.relator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnbase.relator.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
