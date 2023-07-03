package com.synergy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PolicyDocuments")
public class PolicyDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyDocumentId;
	
	private String name;
	private String type;
	
	private byte[] policyDocumentData;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public byte[] getPolicyDocumentData() {
		return policyDocumentData;
	}
	public void setPolicyDocumentData(byte[] policyDocumentData) {
		this.policyDocumentData = policyDocumentData;
	}
	
}
