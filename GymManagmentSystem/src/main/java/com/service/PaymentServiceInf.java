package com.service;

import java.util.List;
import java.util.Optional;

import comm.model.Payment;

public interface PaymentServiceInf {
	public void processPayment(Payment payment);
	public Optional<Payment> getPaymentById(int id);
	public List<Payment> getAllPayment();
	public void updatePayment(Payment payment);
	public void deletePaymentById(int id);

}
