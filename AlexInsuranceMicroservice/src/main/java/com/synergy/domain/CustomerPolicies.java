package com.synergy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerPolicies")
public class CustomerPolicies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerPolicyId;
	
	@OneToOne
	private Customer customer;
	
	private String customerPolicyName;
	private String customerPolicyDescription;
	private String customerPolicyPrice;
	private String customerUsername;
	
	public String getCustomerPolicyName() {
		return customerPolicyName;
	}
	public void setCustomerPolicyName(String customerPolicyName) {
		this.customerPolicyName = customerPolicyName;
	}
	
	public String getCustomerPolicyDescription() {
		return customerPolicyDescription;
	}
	public void setCustomerPolicyDescription(String customerPolicyDescription) {
		this.customerPolicyDescription = customerPolicyDescription;
	}
	
	public String getCustomerPolicyPrice() {
		return customerPolicyPrice;
	}
	public void setCustomerPolicyPrice(String customerPolicyPrice) {
		this.customerPolicyPrice = customerPolicyPrice;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
}
