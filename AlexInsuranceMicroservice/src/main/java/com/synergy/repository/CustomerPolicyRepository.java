package com.synergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.synergy.domain.CustomerPolicies;

public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicies, Integer> {

	CustomerPolicies save(CustomerPolicies customerPolicies);
	List<CustomerPolicies> getCustomerPoliciesByCustomerUsername(String customerUsername);
}
