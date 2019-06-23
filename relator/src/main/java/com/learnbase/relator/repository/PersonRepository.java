package com.learnbase.relator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnbase.relator.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
