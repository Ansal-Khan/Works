package com.learnbase.relator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnbase.relator.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
