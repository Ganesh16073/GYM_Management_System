package com.controller;

import java.util.List;

import comm.model.Payment;

public interface PaymentControllerInf {

	public String processPayment(Payment payment);
	public Payment getPaymentById(int pid);
	public List<Payment> getAllPayment();
	public String updatePayment(Payment payment);
	public String deletePaymentById(int paymentId);
}
