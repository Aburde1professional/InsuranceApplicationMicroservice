package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergy.domain.CustomerClaim;

public interface CustomerClaimRepository extends JpaRepository<CustomerClaim, Long>{

}
