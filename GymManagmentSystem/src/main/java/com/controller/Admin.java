package com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;

import comm.model.Member;
import comm.model.Membership;
import comm.model.Payment;
import comm.model.Trainer;

@Controller
public class Admin implements AdminInf{

	
	@Autowired
	MemberController mcon;
	@Autowired
	TrainerController tcon;
	@Autowired
	PaymentController pcon;
	
	@Autowired
	MembershipController mscon;
	
	@Lookup
	public Member getMember()
	{
		return null;
	}
	
	@Lookup
	public Payment getPayment()
	{
		return null;
	}
	
	@Lookup
	public Membership getMembership()
	{
		return null;
	}
	
	@Lookup
	public Trainer getTrainer()
	{
		return null;
	}
	
	public static int mid=0;
	public static int tid=0;
	
	@Override
	public void addMember() {
	    Scanner sc = new Scanner(System.in);
	    Member m = getMember();
	    
	    try {
	        System.out.println();
	        System.out.println("<< Enter the Member Details >>");
	        m.setMid(++mid);
	        
	        // Name input with exception handling
	        boolean validName = false;
	        while (!validName) {
	            try {
	                System.out.println("Enter the Name of Member");
	                String name = sc.nextLine();
	                if (name.trim().isEmpty()) {
	                    throw new IllegalArgumentException("Name cannot be empty!");
	                }
	                m.setName(name);
	                validName = true;
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        
	        // Mobile Number input with exception handling
	        long mobileNo = 0;
	        boolean validMobile = false;
	        while (!validMobile) {
	            try {
	                System.out.println("Enter the Mobile Number");
	                mobileNo = sc.nextLong();
	                if (String.valueOf(mobileNo).length() != 10) {
	                    throw new IllegalArgumentException("Mobile number must be 10 digits.");
	                }
	                m.setMobileNo(mobileNo);
	                validMobile = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a valid number for mobile.");
	                sc.next(); // Clear the buffer
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }

	        // Gender input with exception handling
	        String gender = null;
	        boolean validGender = false;
	        while (!validGender) {
	            try {
	                System.out.println("Enter the Gender");
	                System.out.println("1 for Male");
	                System.out.println("2 for Female");
	                System.out.println("3 for Others");
	                int chooseGender = sc.nextInt();
	                switch (chooseGender) {
	                    case 1:
	                        gender = "Male";
	                        validGender = true;
	                        break;
	                    case 2:
	                        gender = "Female";
	                        validGender = true;
	                        break;
	                    case 3:
	                        gender = "Others";
	                        validGender = true;
	                        break;
	                    default:
	                        throw new IllegalArgumentException("Invalid choice! Please choose 1 for Male, 2 for Female, or 3 for Others.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a number for gender.");
	                sc.next(); // Clear the buffer
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        m.setGender(gender);

	        // Age input with exception handling
	        int age = 0;
	        boolean validAge = false;
	        while (!validAge) {
	            try {
	                System.out.println("Enter the age greater than 4");
	                age = sc.nextInt();
	                if (age <= 4) {
	                    throw new IllegalArgumentException("Age must be greater than 4.");
	                }
	                m.setAge(age);
	                validAge = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a valid number for age.");
	                sc.next(); // Clear the buffer
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }

	        // Membership Type input with exception handling
	        String membershipType = null;
	        boolean validMembership = false;
	        while (!validMembership) {
	            try {
	                System.out.println("Choose the Membership Type");
	                System.out.println("1 for Monthly");
	                System.out.println("2 for Quarterly");
	                System.out.println("3 for Yearly");
	                int chooseMembership = sc.nextInt();
	                switch (chooseMembership) {
	                    case 1:
	                        membershipType = "Monthly";
	                        validMembership = true;
	                        break;
	                    case 2:
	                        membershipType = "Quarterly";
	                        validMembership = true;
	                        break;
	                    case 3:
	                        membershipType = "Yearly";
	                        validMembership = true;
	                        break;
	                    default:
	                        throw new IllegalArgumentException("Invalid choice! Please choose 1 for Monthly, 2 for Quarterly, or 3 for Yearly.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a number for membership type.");
	                sc.next(); // Clear the buffer
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        m.setMembershipType(membershipType);

	        // Adding the member
	        String result = mcon.addMember(m);
	        System.out.println(result);
	        System.out.println();
	        
	        //-----------------------------------------------------------------------------------------------------------------------
	        // Payment Details input with exception handling
	        Payment pp =getPayment();
	        pp.setPaymentId(mid);

	        double amount = 0;
	        boolean validAmount = false;
	        while (!validAmount) {
	            try {
	                System.out.println("Enter the Payment Amount");
	                amount = sc.nextDouble();
	                if (amount <= 0) {
	                    throw new IllegalArgumentException("Amount must be greater than 0.");
	                }
	                pp.setAmount(amount);
	                validAmount = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a valid number for amount.");
	                sc.next(); // Clear the buffer
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }

	        LocalDate paymentDate = LocalDate.now();
	        pp.setPaymentDate(paymentDate);

	        String paymentMethod = "";
	        boolean validPaymentMethod = false;
	        while (!validPaymentMethod) {
	            try {
	                System.out.println("Enter Payment Method (1 for Credit Card, 2 for Cash, 3 for Bank Transfer, 4 for UPI):");
	                int paymentChoice = sc.nextInt();
	                switch (paymentChoice) {
	                    case 1:
	                        paymentMethod = "Credit Card";
	                        validPaymentMethod = true;
	                        break;
	                    case 2:
	                        paymentMethod = "Cash";
	                        validPaymentMethod = true;
	                        break;
	                    case 3:
	                        paymentMethod = "Bank Transfer";
	                        validPaymentMethod = true;
	                        break;
	                    case 4: 
	                    	 paymentMethod = "UPI Transaction";
	                    	 validPaymentMethod = true;
		                        break;
	                    default:
	                        throw new IllegalArgumentException("Invalid choice! Please choose 1 for Credit Card, 2 for Cash, or 3 for Bank Transfer or 4 for UPI");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a number for payment method.");
	                sc.next(); // Clear the buffer
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        pp.setPaymentMethod(paymentMethod);

	        int memberId = m.getMid();
	        pp.setMemberId(memberId);

	        pcon.processPayment(pp);

	        //-----------------------------------------------------------------------------------------------------------------------
	        // Membership Details input with exception handling
	        System.out.println();
	        System.out.println("Enter the Membership Details");
	        System.out.println();
	        
	        Membership mship = getMembership();
	        mship.setId(mid);
	        
	        LocalDate startDate = LocalDate.now();
	        mship.setStartDate(startDate);

	        String membershipTypeForMship = null;
	        boolean validMshipType = false;
	        while (!validMshipType) {
	            try {
	                System.out.println("Enter the Membership duriation");
	                System.out.println("1 for Monthly");
	                System.out.println("2 for Quarterly");
	                System.out.println("3 for Yearly");
	                int choice = sc.nextInt();
	                switch (choice) {
	                    case 1:
	                        mship.setType("Monthly");
	                        mship.setEndDate(1);
	                        validMshipType = true;
	                        sc.nextLine();
	                        break;
	                    case 2:
	                        mship.setType("Quarterly");
	                        mship.setEndDate(3);
	                        validMshipType = true;
	                        sc.nextLine();
	                        break;
	                    case 3:
	                        mship.setType("Yearly");
	                        mship.setEndDate(12);
	                        validMshipType = true;
	                        sc.nextLine();
	                        break;
	                    default:
	                        throw new IllegalArgumentException("Invalid choice! Please choose 1 for Monthly, 2 for Quarterly, or 3 for Yearly.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a number for membership type.");
	                sc.next(); // Clear the buffer
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        
	        mscon.addMembership(mship);
	    } catch (Exception e) {
	        System.out.println("An unexpected error occurred: " + e.getMessage());
	        e.printStackTrace(); // Print the stack trace for debugging purposes
	    } 
	}

	@Override
	public void getMemberById() {
		Scanner sc=new Scanner(System.in);
		boolean validId=false;
		while(!validId)
		{
			try
			{
				System.out.println("Enter the Id to Search Member");
				int id=sc.nextInt();
				validId=true;
				System.out.println(mcon.getMemberById(id));
				
			}catch (Exception e) {
				System.out.println("Enter the Valid Input");
				e.printStackTrace();
			}
			finally
			{
				sc.nextLine();
			}
		}
		
	}

	@Override
	public void getAllMember() {
		try
		{
			List<Member> list=	mcon.getAllMember();
			list.forEach(member -> System.out.println(member));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Problem in getting All Members................");
		}

	}

	@Override
	public void updateMember() {
		Member mdata = new Member();
		Scanner sc=new Scanner(System.in);
		System.out.println();
		boolean validId=false;
		while(!validId)
		{
			try
			{
				System.out.println("Enter the Member Details to Upadate \t Enter the corect Id ");
				int mid=sc.nextInt();
				mdata.setMid(mid);
				validId=true;
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Enter the Valid Input");
			}
		}
		
		boolean validName=false;
		while(!validName)
		{
			try {
				System.out.println("Enter the Name of Member");
				sc.nextLine();
				String name=sc.nextLine();
				mdata.setName(name);
				validName=true;
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Enter the Valid Input");
			}
		}
		
		boolean validNo=false;
		while(!validNo)
		{
			try {
				System.out.println("Enter the Mobile Number");
				long mobileNo=sc.nextLong();
				long temp=mobileNo;
				int count=0;
				while(temp!=0)
				{
					temp=temp/10;
					count++;
				}
				if(count==10)
				{
					mdata.setMobileNo(mobileNo);
					validNo=true;
				}
				else
				{
					System.out.println("Enter the 10 Digit Number");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Enter the Valid Mobile number");
			}
		}	
		
		boolean validGender=false;
		
		while(!validGender)
		{
			try {
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
				if(gender!=null)
				{
					mdata.setGender(gender);
					validGender=true;
				}
				else
				{
					System.out.println("Enter the Valid choice");
				}		
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Enter the Valid Input");
			}
		}
		
		
		boolean validAge=false;
		while(!validAge)
		{
			try {
				System.out.println("Enter the age greater than 4");
				int age=sc.nextInt();
				if(age>4)
				{
					mdata.setAge(age);
					validAge=true;
				}
				else
				{
					System.out.println("Only Greater than 4 age allowed to join Gym");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Enter the Valid Input");
			}
		}
		
		boolean validMembership=false;
		while(!validMembership)
		{
			try {
				System.out.println("Choose the memberShip Type");
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
				if(membershipType!=null)
				{
					mdata.setMembershipType(membershipType);
					validMembership=true;
				}
				else
				{
					System.out.println("Enter the Valid Membership");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		System.out.println(mcon.updateMember(mdata));
		
		
	}

	@Override
	public void deleteMember() {
		Scanner sc=new Scanner(System.in);
		
		boolean validId=false;
		while(!validId)
		{
			try {
				System.out.println("Enter the Member id delete");
				int mid=sc.nextInt();
				System.out.println(mcon.deleteMemberById(mid));
				validId=true;
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Enter the Valid Input");
			}
			
		
		}
	}

	@Override
	public void addTrainer() {
	    Trainer nt = getTrainer();
	    Scanner sc = new Scanner(System.in);
	    System.out.println();
	    System.out.println("Enter the Trainer Details..");
	    System.out.println();
	    
	    nt.setTid(++tid);
	    
	    // Handle name input
	    System.out.println("Enter the Name of Trainer");
	    String name = sc.nextLine();
	    nt.setName(name);
	    
	    // Handle age input
	    int age = 0;
	    boolean validAge = false;
	    while (!validAge) {
	        try {
	            System.out.println("Enter the Age");
	            age = sc.nextInt();
	            if (age < 4 || age > 100) {
	                throw new IllegalArgumentException("Age should be between 4 and 100.");
	            }
	            validAge = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for age.");
	            sc.nextLine(); // Clear the buffer
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); // Clear the buffer
	        }
	    }
	    nt.setAge(age);
	    
	    // Handle gender input
	    String gender = null;
	    boolean validGender = false;
	    while (!validGender) {
	        try {
	            System.out.println("Enter the Gender");
	            System.out.println("1: Male");
	            System.out.println("2: Female");
	            System.out.println("3: Others");
	            int chooseGender = sc.nextInt();
	            
	            switch (chooseGender) {
	                case 1:
	                    gender = "Male";
	                    validGender = true;
	                    break;
	                case 2:
	                    gender = "Female";
	                    validGender = true;
	                    break;
	                case 3:
	                    gender = "Others";
	                    validGender = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please enter a valid gender option.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for gender.");
	            sc.nextLine(); // Clear the buffer
	        }
	    }
	    nt.setGender(gender);
	    
	    // Handle mobile number input
	    long mobileNo = 0;
	    boolean validMobileNo = false;
	    while (!validMobileNo) {
	        try {
	            System.out.println("Enter the Mobile Number (eg.. 10 digit)");
	            mobileNo = sc.nextLong();
	            if (String.valueOf(mobileNo).length() != 10) {
	                throw new IllegalArgumentException("Mobile number must be exactly 10 digits.");
	            }
	            validMobileNo = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for mobile number.");
	            sc.nextLine(); // Clear the buffer
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); // Clear the buffer
	        }
	    }
	    nt.setMobileNo(mobileNo);
	    
	    // Handle experience input
	    int experienceYear = 0;
	    boolean validExperience = false;
	    while (!validExperience) {
	        try {
	            System.out.println("Enter the Experience in years (eg.. 1 or 2)");
	            experienceYear = sc.nextInt();
	            if (experienceYear < 0) {
	                throw new IllegalArgumentException("Experience cannot be negative.");
	            }
	            validExperience = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for experience.");
	            sc.nextLine(); // Clear the buffer
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); // Clear the buffer
	        }
	    }
	    nt.setExperienceYear(experienceYear);
	    
	    // Handle address input
	    sc.nextLine(); // Clear the buffer before reading next line
	    System.out.println("Enter the Address");
	    String address = sc.nextLine();
	    nt.setAddress(address);
	    
	    // Handle salary input
	    double salary = 0;
	    boolean validSalary = false;
	    while (!validSalary) {
	        try {
	            System.out.println("Enter the Salary");
	            salary = sc.nextDouble();
	            if (salary < 0) {
	                throw new IllegalArgumentException("Salary cannot be negative.");
	            }
	            validSalary = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for salary.");
	            sc.nextLine(); // Clear the buffer
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); // Clear the buffer
	        }
	    }
	    nt.setSalary(salary);
	    tcon.addTraniner(nt);
	   
	}

	@Override
	public void getTrainerById() {
		Scanner sc=new Scanner(System.in);
		boolean validId=false;
		while(!validId)
		{
			try {
				System.out.println("Enter the Id to Search Trainer");
				int id=sc.nextInt();
				System.out.println(tcon.getTraninerById(id));
				validId=true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("enter the Valid Input");
			}
			
		}
		
		
		
	}

	@Override
	public void getAllTrainer() {
		try {
			tcon.getAllTrainer().forEach(member -> System.out.println(member));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public void updateTrainer() {
	    Trainer tdata = new Trainer();
	    Scanner sc = new Scanner(System.in);
	    System.out.println();
	    System.out.println("Enter the Trainer Details..");
	    System.out.println();

	    // Handle trainer ID input
	    int tid = 0;
	    boolean validTid = false;
	    while (!validTid) {
	        try {
	            System.out.println("Enter the Trainer id to update");
	            tid = sc.nextInt();
	            validTid = true; 
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Trainer ID.");
	            sc.nextLine();
	        }
	    }
	    tdata.setTid(tid);

	    // Handle trainer name input
	    sc.nextLine(); 
	    System.out.println("Enter the Name of Trainer to update");
	    String name = sc.nextLine();
	    tdata.setName(name);

	    // Handle age input
	    int age = 0;
	    boolean validAge = false;
	    while (!validAge) {
	        try {
	            System.out.println("Enter the Age");
	            age = sc.nextInt();
	            if (age < 18 || age > 100) {
	                throw new IllegalArgumentException("Age should be between 18 and 100.");
	            }
	            validAge = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for age.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine();
	        }
	    }
	    tdata.setAge(age);

	    // Handle gender input
	    String gender = null;
	    boolean validGender = false;
	    while (!validGender) {
	        try {
	            System.out.println("Enter the Gender");
	            System.out.println("1: Male");
	            System.out.println("2: Female");
	            System.out.println("3: Others");
	            int chooseGender = sc.nextInt();
	            
	            switch (chooseGender) {
	                case 1:
	                    gender = "Male";
	                    validGender = true;
	                    break;
	                case 2:
	                    gender = "Female"; 
	                    validGender = true;
	                    break;
	                case 3:
	                    gender = "Others";
	                    validGender = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please enter a valid gender option.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for gender.");
	            sc.nextLine(); 
	        }
	    }
	    tdata.setGender(gender);

	    // Handle mobile number input
	    long mobileNo = 0;
	    boolean validMobileNo = false;
	    while (!validMobileNo) {
	        try {
	            System.out.println("Enter the Mobile Number (eg.. 10 digit)");
	            mobileNo = sc.nextLong();
	            if (String.valueOf(mobileNo).length() != 10) {
	                throw new IllegalArgumentException("Mobile number must be exactly 10 digits.");
	            }
	            validMobileNo = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for mobile number.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); 
	        }
	    }
	    tdata.setMobileNo(mobileNo);

	    // Handle experience input
	    int experienceYear = 0;
	    boolean validExperience = false;
	    while (!validExperience) {
	        try {
	            System.out.println("Enter the Experience in years (eg.. 1 or 2)");
	            experienceYear = sc.nextInt();
	            if (experienceYear < 0) {
	                throw new IllegalArgumentException("Experience cannot be negative.");
	            }
	            validExperience = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for experience.");
	            sc.nextLine(); // Clear the buffer
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); // Clear the buffer
	        }
	    }
	    tdata.setExperienceYear(experienceYear);

	    // Handle address input
	    sc.nextLine();
	    System.out.println("Enter the Address");
	    String address = sc.nextLine();
	    tdata.setAddress(address);

	    // Handle salary input
	    double salary = 0;
	    boolean validSalary = false;
	    while (!validSalary) {
	        try {
	            System.out.println("Enter the Salary");
	            salary = sc.nextDouble();
	            if (salary < 0) {
	                throw new IllegalArgumentException("Salary cannot be negative.");
	            }
	            validSalary = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for salary.");
	            sc.nextLine();
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); 
	        }
	    }
	    tdata.setSalary(salary);

	  
	    System.out.println(tcon.updateTrainer(tdata));
	    
	}

	@Override
	public void deleteTrainer() {
		Scanner sc=new Scanner(System.in);
		boolean validId=false;
		while(!validId)
		{
			try
			{
				System.out.println("Enter the Trainer Id To Delete");
				int id=sc.nextInt();
				System.out.println(tcon.deleteTrainerById(id));
				validId=true;
			}
			catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
		
		
	}

	@Override
	public void processPayment() {
	    Payment pp = getPayment();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Payment Details");
	    System.out.println();

	    // Handle Payment ID (random generation is fine, no user input)
	    int paymentId = new Random().nextInt(1000);
	    pp.setPaymentId(paymentId);

	    // Handle amount input
	    double amount = 0;
	    boolean validAmount = false;
	    while (!validAmount) {
	        try {
	            System.out.println("Enter the Amount");
	            amount = sc.nextDouble();
	            if (amount <= 0) {
	                throw new IllegalArgumentException("Amount should be greater than zero.");
	            }
	            validAmount = true; // valid input
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for amount.");
	            sc.nextLine(); // Clear the buffer
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); // Clear the buffer
	        }
	    }
	    pp.setAmount(amount);

	    // Handle date input
	    LocalDate paymentDate = null;
	    boolean validDate = false;
	    while (!validDate) {
	        try {
	            System.out.println("Enter the Date (yyyy-MM-dd):");
	            String dateInput = sc.next();
	            paymentDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	            validDate = true; // valid date format
	        } catch (DateTimeParseException e) {
	            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
	        }
	    }
	    pp.setPaymentDate(paymentDate);

	    // Handle payment method selection
	    String paymentMethod = null;
	    boolean validPaymentMethod = false;
	    while (!validPaymentMethod) {
	        try {
	            System.out.println("Enter Payment Method (1 for Credit Card, 2 for Cash, 3 for Bank Transfer, 4 for UPI Transaction):");
	            int paymentChoice = sc.nextInt();

	            switch (paymentChoice) {
	                case 1:
	                    paymentMethod = "Credit Card";
	                    validPaymentMethod = true;
	                    break;
	                case 2:
	                    paymentMethod = "Cash";
	                    validPaymentMethod = true;
	                    break;
	                case 3:
	                    paymentMethod = "Bank Transfer";
	                    validPaymentMethod = true;
	                    break;
	                case 4:
	                    paymentMethod = "UPI Transaction";
	                    validPaymentMethod = true;
	                    break;
	                default:
	                    System.out.println("Invalid payment method selected. Please select a valid option.");
	                    break;
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number for payment method.");
	            sc.nextLine(); 
	        }
	    }
	    pp.setPaymentMethod(paymentMethod);

	    // Handle member ID input
	    int memberId = 0;
	    boolean validMemberId = false;
	    while (!validMemberId) {
	        try {
	            System.out.println("Enter Member ID:");
	            memberId = sc.nextInt();
	            if (memberId <= 0) {
	                throw new IllegalArgumentException("Member ID should be greater than zero.");
	            }
	            validMemberId = true; 
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Member ID.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); 
	        }
	    }
	    pp.setMemberId(memberId);

	    pcon.processPayment(pp);
	}

	@Override
	public void getPaymentById() {
	    Scanner sc = new Scanner(System.in);
	    
	    // Handle payment ID input with exception handling
	    int paymentId = 0;
	    boolean validInput = false;
	    while (!validInput) {
	        try {
	            System.out.println("Enter the Payment Id:");
	            paymentId = sc.nextInt();
	            
	            // Assuming payment ID should be a positive integer
	            if (paymentId <= 0) {
	                throw new IllegalArgumentException("Payment ID should be greater than zero.");
	            }
	            
	            validInput = true; 
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Payment ID.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); 
	        }
	    }
	    
	    // Try to retrieve the payment by ID
	    try {
	        Payment paymentDetails = pcon.getPaymentById(paymentId);
	        
	        if (paymentDetails == null) {
	            System.out.println("No payment found with the provided ID.");
	        } else {
	            System.out.println(paymentDetails);
	        }
	        
	    } catch (Exception e) {
	        System.out.println("An error occurred while retrieving payment details: " + e.getMessage());
	    }
	}

	@Override
	public void getAllPayment() {
	    try {
	        
	        List<Payment> payments = pcon.getAllPayment();
	       
	        if (payments == null || payments.isEmpty()) {
	            System.out.println("No payments found.");
	        } else {
	            
	            payments.forEach(p -> System.out.println(p)); 
	        }
	    } catch (Exception e) {
	        System.out.println("An error occurred while retrieving payments: " + e.getMessage());
	    }
	}

	@Override
	public void updatePayment() {
	    Payment pdata = new Payment();
	    Scanner sc = new Scanner(System.in);

	    // Handle Payment ID input
	    int paymentId = 0;
	    boolean validPaymentId = false;
	    while (!validPaymentId) {
	        try {
	            System.out.println("Enter the Payment Id:");
	            paymentId = sc.nextInt();
	            if (paymentId <= 0) {
	                throw new IllegalArgumentException("Payment ID should be greater than zero.");
	            }
	            pdata.setPaymentId(paymentId);
	            validPaymentId = true; 
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Payment ID.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine();
	        }
	    }

	    // Handle Amount input
	    double amount = 0;
	    boolean validAmount = false;
	    while (!validAmount) {
	        try {
	            System.out.println("Enter the Amount:");
	            amount = sc.nextDouble();
	            if (amount <= 0) {
	                throw new IllegalArgumentException("Amount must be greater than zero.");
	            }
	            pdata.setAmount(amount);
	            validAmount = true; 
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid amount.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine();
	        }
	    }

	    // Handle Date input
	    LocalDate paymentDate = null;
	    boolean validDate = false;
	    while (!validDate) {
	        try {
	            System.out.println("Enter the Date (yyyy-MM-dd):");
	            String dateInput = sc.next();
	            paymentDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	            pdata.setPaymentDate(paymentDate);
	            validDate = true; 
	        } catch (Exception e) {
	            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
	            sc.nextLine(); 
	        }
	    }

	    // Handle Payment Method input
	    String paymentMethod = "";
	    boolean validPaymentMethod = false;
	    while (!validPaymentMethod) {
	        try {
	            System.out.println("Enter Payment Method (1 for Credit Card, 2 for Cash, 3 for Bank Transfer):");
	            int paymentChoice = sc.nextInt();
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
	            validPaymentMethod = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please select a valid payment method.");
	            sc.nextLine();
	        }
	    }

	    // Handle Member ID input
	    int memberId = 0;
	    boolean validMemberId = false;
	    while (!validMemberId) {
	        try {
	            System.out.println("Enter Member ID:");
	            memberId = sc.nextInt();
	            if (memberId <= 0) {
	                throw new IllegalArgumentException("Member ID should be greater than zero.");
	            }
	            pdata.setMemberId(memberId);
	            validMemberId = true; 
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Member ID.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); 
	        }
	    }

	    // Try to update the payment
	    try {
	        String result = pcon.updatePayment(pdata);  
	        System.out.println(result);  
	    } catch (Exception e) {
	        System.out.println("An error occurred while updating the payment: " + e.getMessage());
	    }
	}

	@Override
	public void deletePaymentById() {
	    Scanner sc = new Scanner(System.in);

	    // Prompt for payment ID with validation
	    int paymentId = 0;
	    boolean validInput = false;
	    while (!validInput) {
	        try {
	            System.out.println("Enter the Payment ID to delete:");
	            paymentId = sc.nextInt();
	            
	            if (paymentId <= 0) {
	                throw new IllegalArgumentException("Payment ID should be greater than zero.");
	            }

	            validInput = true;
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Payment ID.");
	            sc.nextLine(); 
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            sc.nextLine(); 
	        }
	    }

	    // Attempt to delete the payment by ID
	    try {
	        String result = pcon.deletePaymentById(paymentId);  
	        System.out.println(result); 
	    } catch (Exception e) {
	       
	        System.out.println("An error occurred while deleting the payment: " + e.getMessage());
	    }
	}
	
	
	
	public void addMembership()
	{
		Membership mship=getMembership();
		
		Scanner sc=new Scanner(System.in);
		mship.setId(new Random().nextInt(1000));
		
        LocalDate startDate = LocalDate.now();
        mship.setStartDate(startDate);
		
		System.out.println("Enter the Membership Type");
		System.out.println("1 for Monthly");
		System.out.println("2 for Quaterly");
		System.out.println("3 for Yearly");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			mship.setType("Monthly");
			mship.setEndDate(1); // setting the end data based on membership internelly plusmonth()
			break;
		case 2:
			mship.setType("Quarterly");
			mship.setEndDate(3);
			break;
		case 3:
			mship.setType("Yearly");
			mship.setEndDate(12);
			break;
		
			default:
				mship.setType(null);
				mship.setEndDate(0);
				System.out.println("Invalid choice");
		}
			
		mscon.addMembership(mship);
	}
	
	
	public void getMembershipById()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id to find Membership");
		int id;
		try
		{
			id=sc.nextInt();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Enter the correct id");
			id=sc.nextInt();
		}
		System.out.println(mscon.getMembershipById(id));
		
	}
	
	public void getAllMembership()
	{
		List<Membership> l=mscon.getAllMember();
		l.forEach(ms -> System.out.println(ms));
	}
	
	public void updateMembership()
	{
		Membership mship=new Membership();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Membership id to update");
		int id=sc.nextInt();
		mship.setId(id);
		
		System.out.println("Enter the Date (yyyy-MM-dd):");
       String dateInput = sc.next();
      LocalDate UDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        mship.setStartDate(UDate);
		
		System.out.println("Enter the Membership Type");
		System.out.println("1 for Monthly");
		System.out.println("2 for Quaterly");
		System.out.println("3 for Yearly");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			mship.setType("Monthly");
			mship.setEndDate(1); // setting the end data based on membership
			break;
		case 2:
			mship.setType("Quarterly");
			mship.setEndDate(3);
			break;
		case 3:
			mship.setType("Yearly");
			mship.setEndDate(12);
			break;
		
			default:
				mship.setType(null);
				mship.setEndDate(0);
				System.out.println("Invalid choice");
		}
		System.out.println(mscon.updateMembership(mship));
			
		
	}
	
	
	public void deleteMembershipById()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id to Delete Membership");
		int id;
		try
		{
			id=sc.nextInt();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Enter the correct id");
			id=sc.nextInt();
		}
		mscon.deleteMembershipById(id);
		
	}
	


}
