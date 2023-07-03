package com.synergy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.domain.PaymentData;
import com.synergy.repository.PaymentDataRepository;

@Service
public class PaymentDataService {

	@Autowired
	PaymentDataRepository paymentDataRepository;
	
	public PaymentData savePaymentData(PaymentData paymentData) {
		return paymentDataRepository.save(paymentData);
	}

}
