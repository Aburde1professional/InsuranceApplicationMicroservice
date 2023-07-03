package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.PaymentData;

@Repository
public interface PaymentDataRepository extends JpaRepository<PaymentData, Long> {
	
}
