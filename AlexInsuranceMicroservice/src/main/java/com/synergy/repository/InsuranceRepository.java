package com.synergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.Customer;
import com.synergy.domain.Policies;

@Repository
public interface InsuranceRepository extends JpaRepository<Policies, Integer> {
	public List<Policies> findByPolicyName(String searchString);

	public Customer save(Customer customer);
}