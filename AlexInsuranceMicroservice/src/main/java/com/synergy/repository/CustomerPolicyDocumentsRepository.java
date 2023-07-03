package com.synergy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.domain.PolicyDocuments;

public interface CustomerPolicyDocumentsRepository extends JpaRepository<PolicyDocuments, Long> {

	Optional<PolicyDocuments> findByName(String fileName);
	
}
