package com.synergy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.domain.CustomerPolicies;
import com.synergy.domain.PolicyDocuments;
import com.synergy.repository.CustomerPolicyRepository;
import com.synergy.repository.CustomerRepository;

@Service
public class CustomerPolicyServiceImpl implements CustomerPolicyService {
	
	@Autowired
	CustomerPolicyRepository customerPolicyRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	public CustomerPolicies saveCustomerPolicies(CustomerPolicies customerPolicies) {
		customerRepository.save(customerPolicies.getCustomer());
		return customerPolicyRepository.save(customerPolicies);
	}

	public List<CustomerPolicies> getCustomerPoliciesByCustomerUsername(String customerUsername) {
		return customerPolicyRepository.getCustomerPoliciesByCustomerUsername(customerUsername);
	}
}
