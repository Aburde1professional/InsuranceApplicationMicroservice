package com.synergy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.domain.CustomerClaim;
import com.synergy.repository.CustomerClaimRepository;

@Service
public class CustomerClaimServiceImpl implements CustomerClaimService {
	
	@Autowired
	CustomerClaimRepository customerClaimRepository;

	public CustomerClaim saveCustomerClaim(CustomerClaim customerClaim) {
		return customerClaimRepository.save(customerClaim);
	}

	public List<CustomerClaim> getAllCustomerClaims() {
		return customerClaimRepository.findAll();
	}

}
