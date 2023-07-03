package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
