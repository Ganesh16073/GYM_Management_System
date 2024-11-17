package comm.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Payment {

	private int paymentId; // Unique identifier for each payment
	private double amount; // Payment amount
	@Autowired
	private LocalDate paymentDate; // Date of the payment
	private String paymentMethod; // Payment method (e.g., "Credit Card", "Cash", "Bank Transfer")
	private int memberId; // ID of the member making the payment

	// Default constructor
	public Payment() {
	}

	// Parameterized constructor
	public Payment(int paymentId, double amount, LocalDate paymentDate, String paymentMethod, int memberId) {
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.memberId = memberId;
	}

	// Getters and Setters
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", paymentMethod=" + paymentMethod + ", memberId=" + memberId + "]";
	}
}
