package com.synergy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Policies")
public class Policies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyId;
	
	private String policyDescription;
	private String policyName;
	private double policyPrice;
	
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	
	public double getPolicyPrice() {
		return policyPrice;
	}
	public void setPolicyPrice(double policyPrice) {
		this.policyPrice = policyPrice;
	}
	
	public String getPolicyDescription() {
		return policyDescription;
	}
	public void setPolicyDescription(String policyDescription) {
		this.policyDescription = policyDescription;
	}
}