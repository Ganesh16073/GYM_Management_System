package com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import comm.model.Member;
import comm.model.Payment;
import comm.model.Trainer;

@Controller
public class Admin implements AdminInf{

	Member mdata;
	@Autowired
	public Admin(Member member)
	{
		this.mdata=member;
		System.out.println("Triggered");
	}
	@Autowired
	MemberController mcon;
	@Autowired
	TrainerController tcon;
	@Autowired
	PaymentController pcon;
	
	
	
	
	@Autowired
	Trainer tdata;
	
	@Autowired
	Payment pdata;
	
	@Override
	public void addMemebr() {
		
		Member m = new Member();
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the Member Details");
		int mid=new Random().nextInt(1000);
		m.setMid(mid);
		
		
		System.out.println("Enter the Name of Member");
		String name=sc.nextLine();
		m.setName(name);
		
		System.out.println("Enter the Mobile Number");
		long mobileNo=sc.nextLong();
		m.setMobileNo(mobileNo);
		
		
		System.out.println("Enter the Gender");
		System.out.println("1: Male");
		System.out.println("2: Female");
		System.out.println("3: Others");
		int chooseGender=sc.nextInt();
		String gender;;
		switch(chooseGender)
		{
		case 1:
			gender="Male";
			break;
		case 2:
			gender="Femele";
			break;
		case 3:
			gender="Others";
			break;
		default:
			gender=null;
		}
		m.setGender(gender);
		
		System.out.println("Enter the age greater than 4");
		int age=sc.nextInt();
		m.setAge(age);
		
		
		System.out.println("Choosethe memberShip Type");
		System.out.println("1: Monthly");
		System.out.println("2: Quarterly");
		System.out.println("3: Yearly");
		int choosemembership=sc.nextInt();
		String membershipType;
		switch(choosemembership)
		{
		case 1:
			membershipType=" Monthly";
			break;
		case 2:
			membershipType="Quarterly";
			break;
		case 3:
			membershipType="Yearly";
			break;
		default:
			membershipType=null;
		}
		m.setMembershipType(membershipType);
		
		String result=mcon.addMember(m);
		System.out.println(result);
		

	}

	@Override
	public void getMemberById() {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id to Search Member");
		int id=sc.nextInt();
		
		System.out.println(mcon.getMemberById(id));
		
	}

	@Override
	public void getAllMember() {
	List<Member> list=	mcon.getAllMember();
	for(int i=0;i<list.size();i++)
	{
		System.out.println(list.get(i));
	}
		//.forEach(member -> System.out.println(member));

		
	}

	@Override
	public void updateMember() {
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the Member Details to Upadate \t Enter the corect Id ");
		int mid=sc.nextInt();
		mdata.setMid(mid);
		
		
		System.out.println("Enter the Name of Member");
		String name=sc.nextLine();
		mdata.setName(name);
		
		System.out.println("Enter the Mobile Number");
		long mobileNo=sc.nextLong();
		mdata.setMobileNo(mobileNo);
		
		
		System.out.println("Enter the Gender");
		System.out.println("1: Male");
		System.out.println("2: Female");
		System.out.println("3: Others");
		int chooseGender=sc.nextInt();
		String gender;;
		switch(chooseGender)
		{
		case 1:
			gender="Male";
			break;
		case 2:
			gender="Femele";
			break;
		case 3:
			gender="Others";
			break;
		default:
			gender=null;
		}
		mdata.setGender(gender);
		
		System.out.println("Enter the age greater than 4");
		int age=sc.nextInt();
		mdata.setAge(age);
		
		
		System.out.println("Choosethe memberShip Type");
		System.out.println("1: Monthly");
		System.out.println("2: Quarterly");
		System.out.println("3: Yearly");
		int choosemembership=sc.nextInt();
		String membershipType;
		switch(choosemembership)
		{
		case 1:
			membershipType=" Monthly";
			break;
		case 2:
			membershipType="Quarterly";
			break;
		case 3:
			membershipType="Yearly";
			break;
		default:
			membershipType=null;
		}
		mdata.setMembershipType(membershipType);
		
		
		System.out.println(mcon.updateMember(mdata));
		
		
	}

	@Override
	public void deleteMember() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Member id delete");
		int mid=sc.nextInt();
		System.out.println(mcon.deleteMemberById(mid));
		
	}

	@Override
	public void addTrainer() {
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the Trainer Details..");
		System.out.println();
		
		int tid=new Random().nextInt(1000);
		tdata.setTid(tid);;
		
		System.out.println("Enter the Name of Trainer");
		String name=sc.nextLine();
		tdata.setName(name);
		
		System.out.println("Enter the Age");
		int age=sc.nextInt();
		tdata.setAge(age);
		
		System.out.println("Enter the Gender");
		System.out.println("1: Male");
		System.out.println("2: Female");
		System.out.println("3: Others");
		int chooseGender=sc.nextInt();
		String gender;
		switch(chooseGender)
		{
		case 1:
			gender="Male";
			break;
		case 2:
			gender="Femele";
			break;
		case 3:
			gender="Others";
			break;
		default:
			gender=null;
		}
		tdata.setGender(gender);
		
		System.out.println("Enter the Mobile Number (eg.. 10 digit");
		long mobileNo=sc.nextLong();
		tdata.setMobileNo(mobileNo);
		
		System.out.println("Enter the Experience in years (eg.. 1 or 2");
		int experienceYear=sc.nextInt();
		tdata.setExperienceYear(experienceYear);
		
		System.out.println("Enter the Address");
		sc.nextLine();
		String address=sc.nextLine();
		tdata.setAddress(address);
		
		System.out.println("Enter the Salary");
		double salary=sc.nextDouble();
		tdata.setSalary(salary);
		tcon.addTraniner(tdata);
		
	}

	@Override
	public void getTrainerById() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id to Search Trainer");
		int id=sc.nextInt();
		System.out.println(tcon.getTraninerById(id));
		
	}

	@Override
	public void getAllTrainer() {
		tcon.getAllTrainer().forEach(member -> System.out.println(member));
		
	}

	@Override
	public void updateTrainer() {
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the Trainer Details..");
		System.out.println();
		
		System.out.println("Enter the Trainer id to update");
		int tid=sc.nextInt();
		tdata.setTid(tid);
		
		System.out.println("Enter the Name of Trainer to update");
		String name=sc.nextLine();
		tdata.setName(name);
		
		System.out.println("Enter the Age");
		int age=sc.nextInt();
		tdata.setAge(age);
		
		System.out.println("Enter the Gender");
		System.out.println("1: Male");
		System.out.println("2: Female");
		System.out.println("3: Others");
		int chooseGender=sc.nextInt();
		String gender;
		switch(chooseGender)
		{
		case 1:
			gender="Male";
			break;
		case 2:
			gender="Femele";
			break;
		case 3:
			gender="Others";
			break;
		default:
			gender=null;
		}
		tdata.setGender(gender);
		
		System.out.println("Enter the Mobile Number (eg.. 10 digit");
		long mobileNo=sc.nextLong();
		tdata.setMobileNo(mobileNo);
		
		System.out.println("Enter the Experience in years (eg.. 1 or 2");
		int experienceYear=sc.nextInt();
		tdata.setExperienceYear(experienceYear);
		
		System.out.println("Enter the Address");
		sc.nextLine();
		String address=sc.nextLine();
		tdata.setAddress(address);
		
		System.out.println("Enter the Salary");
		double salary=sc.nextDouble();
		tdata.setSalary(salary);
		
		System.out.println(tcon.updateTrainer(tdata));
		sc.close();
	}

	@Override
	public void deleteTrainer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Trainer Id To Delete");
		int id=sc.nextInt();
		System.out.println(tcon.deleteTrainerById(id));
		
		
	}

	@Override
	public void processPayment() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Payment Details");
		System.out.println();
		
		
		int paymentId=new Random().nextInt(1000);
		pdata.setPaymentId(paymentId);
		
		System.out.println("Enter the Amount");
		double amount=sc.nextDouble();
		pdata.setAmount(amount);
		
		 System.out.println("Enter the Date (yyyy-MM-dd):");
		 String dateInput = sc.next();
		 LocalDate paymentDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	     pdata.setPaymentDate(paymentDate);
		    
	    
	     System.out.println("Enter Payment Method (1 for Credit Card, 2 for Cash, 3 for Bank Transfer):");
	     int paymentChoice = sc.nextInt();
	     String paymentMethod = "";

	     switch (paymentChoice) {
	         case 1:
	             paymentMethod = "Credit Card";
	             break;
	         case 2:
	             paymentMethod = "Cash";
	             break;
	         case 3:
	             paymentMethod = "Bank Transfer";
	             break;
	         default:
	             System.out.println("Invalid payment method selected. Defaulting to 'Unknown'.");
	             paymentMethod = "Unknown";
	             break;
	     }

	     pdata.setPaymentMethod(paymentMethod);
	     
	     System.out.println("Enter Member ID:");
	     int memberId = sc.nextInt();
	     pdata.setMemberId(memberId);
	     
	     pcon.processPayment(pdata);
	    
		
	}

	@Override
	public void getPaymentById() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Payent Id");
		System.out.println(pcon.getPaymentById(sc.nextInt()));
		
	}

	@Override
	public void getAllPayment() {
		pcon.getAllPayment().forEach(p -> System.out.println(p));
		
	}

	@Override
	public void updatePayment() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Payent Id");
		int id=sc.nextInt();
		pdata.setPaymentId(id);
		
		System.out.println("Enter the Amount");
		double amount=sc.nextDouble();
		pdata.setAmount(amount);
		
		 System.out.println("Enter the Date (yyyy-MM-dd):");
		 String dateInput = sc.next();
		 LocalDate paymentDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	     pdata.setPaymentDate(paymentDate);
		    
	    
	     System.out.println("Enter Payment Method (1 for Credit Card, 2 for Cash, 3 for Bank Transfer):");
	     int paymentChoice = sc.nextInt();
	     String paymentMethod = "";

	     switch (paymentChoice) {
	         case 1:
	             paymentMethod = "Credit Card";
	             break;
	         case 2:
	             paymentMethod = "Cash";
	             break;
	         case 3:
	             paymentMethod = "Bank Transfer";
	             break;
	         default:
	             System.out.println("Invalid payment method selected. Defaulting to 'Unknown'.");
	             paymentMethod = "Unknown";
	             break;
	     }

	     pdata.setPaymentMethod(paymentMethod);
	     
	     System.out.println("Enter Member ID:");
	     int memberId = sc.nextInt();
	     pdata.setMemberId(memberId);
		
		System.out.println(pcon.updatePayment(pdata));
		
	}

	@Override
	public void deletePaymentById() {
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		System.out.println(pcon.deletePaymentById(id));
		sc.close();
	}

}
