package com.synergy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.synergy.domain.Customer;
import com.synergy.domain.CustomerClaim;
import com.synergy.domain.CustomerPolicies;
import com.synergy.domain.Policies;
import com.synergy.service.CustomerClaimServiceImpl;
import com.synergy.service.CustomerPolicyDocumentServiceImpl;
import com.synergy.service.CustomerPolicyServiceImpl;
import com.synergy.service.InsuranceServiceImpl;

@RestController
public class InsuranceController {
	
	@Autowired
	InsuranceServiceImpl insuranceService;
	
	@Autowired
	CustomerPolicyServiceImpl customerPolicyService;
	
	@Autowired
	CustomerPolicyDocumentServiceImpl customerDocumentService;
	
	@Autowired
	CustomerClaimServiceImpl customerClaimService;
	
	@RequestMapping(value = "/getInsuranceByPolicies/{searchString}", method = RequestMethod.GET)
	public List<Policies> searchPolicies(@PathVariable String searchString) {
		return insuranceService.searchPolicies(searchString);
	}
	
	@RequestMapping(value = "getPoliciesByCustomerUsername/{customerUsername}", method = RequestMethod.GET)
	public List<CustomerPolicies> getCustomerPolicies(@PathVariable String customerUsername) {
		return customerPolicyService.getCustomerPoliciesByCustomerUsername(customerUsername);
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return insuranceService.saveCustomer(customer);
	}
	
	@RequestMapping(value = "/saveCustomerPolicy", method = RequestMethod.POST)
	public CustomerPolicies saveCustomerPolicies(@RequestBody CustomerPolicies customerPolicies) {
		return customerPolicyService.saveCustomerPolicies(customerPolicies);
	}
	
	@RequestMapping(value = "/saveCustomerClaim", method = RequestMethod.POST)
	public CustomerClaim saveCustomerClaim(@RequestBody CustomerClaim customerClaim) {
		return customerClaimService.saveCustomerClaim(customerClaim);
	}
	
	@RequestMapping(value = "/getAllClaimsAdmin", method = RequestMethod.GET)
	public List<CustomerClaim> getAllCustomerClaims() {
		return customerClaimService.getAllCustomerClaims();
	}
}