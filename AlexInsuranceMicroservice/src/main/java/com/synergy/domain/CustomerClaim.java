package com.synergy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerClaims")
public class CustomerClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int customerClaimId;

	private String claimantName;
	private String claimantContactNumber;
	private String claimantDateOfBirth;
	private String accidentLocation;
	private String accidentDescription;
	private String witnessName;
	private String claimantUsername;
	
	@Column(name = "claimStatus")
	private String claimStatus = "Pending";
	
	public String getClaimantName() {
		return claimantName;
	}
	public void setClaimantName(String claimantName) {
		this.claimantName = claimantName;
	}
	
	public String getClaimantContactNumber() {
		return claimantContactNumber;
	}
	public void setClaimantContactNumber(String claimantContactNumber) {
		this.claimantContactNumber = claimantContactNumber;
	}
	
	public String getClaimantDateOfBirth() {
		return claimantDateOfBirth;
	}
	public void setClaimantDateOfBirth(String claimantDateOfBirth) {
		this.claimantDateOfBirth = claimantDateOfBirth;
	}
	
	public String getAccidentLocation() {
		return accidentLocation;
	}
	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocation = accidentLocation;
	}
	
	public String getAccidentDescription() {
		return accidentDescription;
	}
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	
	public String getWitnessName() {
		return witnessName;
	}
	public void setWitnessName(String witnessName) {
		this.witnessName = witnessName;
	}
	
	public String getClaimantUsername() {
		return claimantUsername;
	}
	public void setClaimantUsername(String claimantUsername) {
		this.claimantUsername = claimantUsername;
	}
	
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
}
	
