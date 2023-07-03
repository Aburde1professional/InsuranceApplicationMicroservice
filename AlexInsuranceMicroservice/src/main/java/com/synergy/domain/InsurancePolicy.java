package com.synergy.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="insurance_policies")
public class InsurancePolicy {	
	@Id
	private int insuranceId;
	private double averageMonthlyCost;
	@ManyToMany
	private Set<Policies> policies = new HashSet<>();
	
	public InsurancePolicy(int insuranceId, double averageMonthlyCost, Set<Policies> policies) {
		super();
		this.insuranceId = insuranceId;
		this.setAverageMonthlyCost(averageMonthlyCost);
		this.policies = policies;
	}
	

	public double getAverageMonthlyCost() {
		return averageMonthlyCost;
	}
	public void setAverageMonthlyCost(double averageMonthlyCost) {
		this.averageMonthlyCost = averageMonthlyCost;
	}
	
}