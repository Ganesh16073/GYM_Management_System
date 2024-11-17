package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.PaymentService;

import comm.model.Payment;

@Controller
public class PaymentController implements PaymentControllerInf {

	@Autowired
	PaymentService ps;
	@Override
	public String processPayment(Payment payment) {
		ps.processPayment(payment);
		return "Payment Added Sucessfull";
	}

	@Override
	public Payment getPaymentById(int pid) {
		Optional<Payment> op=ps.getPaymentById(pid);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			System.out.println("Payment Not Found by Id "+pid);
			return null;
		}
	}

	@Override
	public List<Payment> getAllPayment() {
		
		return ps.getAllPayment();
	}

	@Override
	public String updatePayment(Payment payment) {
		Optional<Payment> op=ps.getPaymentById(payment.getPaymentId());
		if(op.isPresent())
		{
			ps.updatePayment(payment);
			return "Payment Updated"+ps;
		}
		else
		{
			return "PayMent not Found ";
		}
		
	}

	@Override
	public String deletePaymentById(int paymentId) {
		Optional<Payment> op=ps.getPaymentById(paymentId);
		if(op.isPresent())
		{
			ps.deletePaymentById(paymentId);
			return "Payment Deleted Sucessfull";
		}
		else
		{
			return "Payment Not Found byn id "+paymentId;
		}
	}

}

