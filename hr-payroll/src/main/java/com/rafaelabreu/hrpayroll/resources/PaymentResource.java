package com.rafaelabreu.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelabreu.hrpayroll.entities.Payment;
import com.rafaelabreu.hrpayroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
    @CircuitBreaker(name = "paymentService", fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = paymentService.getPayment(workerId,days);
		return ResponseEntity.ok(payment);
	}
    
    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days, Throwable e) {
        Payment payment = new Payment("Fallback", 400.0, days);
        return ResponseEntity.ok(payment);
    }
}
