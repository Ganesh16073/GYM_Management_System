package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comm.model.Payment;

@Service
public class PaymentService implements PaymentServiceInf {

	private List<Payment> pay=new ArrayList<>();
	
	@Override
	public void processPayment(Payment payment) {
		pay.add(payment);
		System.out.println("Payment Added => "+payment);
		
	}

	@Override
	public Optional<Payment> getPaymentById(int id) {
		
		return pay.stream().filter(payment -> payment.getPaymentId()==id).findFirst();
	}

	@Override
	public List<Payment> getAllPayment() {
		
		return new ArrayList<Payment>(pay);
	}

	@Override
	public void updatePayment(Payment payment) {
		getPaymentById(payment.getPaymentId()).ifPresent(existingPayment ->
		{
			existingPayment.setAmount(payment.getAmount());
			existingPayment.setMemberId(payment.getMemberId());
			existingPayment.setPaymentDate(payment.getPaymentDate());
			existingPayment.setPaymentMethod(payment.getPaymentMethod());
			System.out.println("Payment deatails updated => "+payment);
		});
		
	}

	@Override
	public void deletePaymentById(int id) {
		pay.removeIf(payment -> payment.getPaymentId()==id);
		System.out.println("Payment Deleted by id "+id);
		
	}

}
