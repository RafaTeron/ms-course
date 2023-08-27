package com.rafaelabreu.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.rafaelabreu.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workeId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}
