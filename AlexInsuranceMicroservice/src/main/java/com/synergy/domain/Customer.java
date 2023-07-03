package com.synergy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int customerId;

	private String customerName;
	private String customerVehicle;
	private String customerDateOfBirth;
	private double customerPriceLimit;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerVehicle() {
		return customerVehicle;
	}
	public void setCustomerVehicle(String customerVehicle) {
		this.customerVehicle = customerVehicle;
	}
	
	public String getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}
	public void setCustomerAge(String customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}
	
	public double getCustomerPriceLimit() {
		return customerPriceLimit;
	}
	public void setCustomerPriceLimit(double customerPriceLimit) {
		this.customerPriceLimit = customerPriceLimit;
	}
}
