package com.synergy.service;

import java.util.List;

import com.synergy.domain.Policies;

public interface InsuranceService {
	public List<Policies> searchPolicies(String searchString);
	
}