package com.synergy.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.domain.Customer;
import com.synergy.domain.Policies;
import com.synergy.repository.CustomerPolicyRepository;
import com.synergy.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Override
	public List<Policies> searchPolicies(String searchString) {
		return insuranceRepository.findByPolicyName(searchString);
	}

	public Customer saveCustomer(Customer customer) {
		return insuranceRepository.save(customer);
	}
}
