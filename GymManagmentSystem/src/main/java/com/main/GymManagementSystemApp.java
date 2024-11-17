package com.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;
import com.controller.Admin;

public class GymManagementSystemApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Admin admin=cxt.getBean("admin",Admin.class);
		Scanner scanner = new Scanner(System.in);
        System.out.println("========================================== Welcome to Gym Management System  ========================================== ");
        System.out.println();
        boolean running = true;
        while (running) {
        	
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ENTER THE CHOICE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
            System.out.println(" 1 =>> Add Member \t2 =>> Get Member by ID  \t3 =>> Get All Members \t 4 =>> Update Member \t5 =>> Delete Member");
           
            
            System.out.println(" 6 =>> Add Trainer \t7 =>> Get Trainer by ID \t8 =>> Get All Trainers \t 9 =>> Update Trainer \t10 =>> Delete Trainer");
           
            System.out.println(" 11 =>> Process Payment 12 =>> Get Payment by ID \t13 =>> Get All Payments  14 =>> Update Payment \t15 =>> Delete Payment");
            System.out.println();
            
            System.out.println(" 0 =>> Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                	admin=cxt.getBean("admin",Admin.class);
                    admin.addMemebr();
                    break;
                case 2:
                    admin.getMemberById();
                    break;
                case 3:
                    admin.getAllMember();
                    break;
                case 4:
                    admin.updateMember();
                    break;
                case 5:
                    admin.deleteMember();
                    break;
                case 6:
                    admin.addTrainer();
                    break;
                case 7:
                    admin.getTrainerById();
                    break;
                case 8:
                    admin.getAllTrainer();
                    break;
                case 9:
                    admin.updateTrainer();
                    break;
                case 10:
                    admin.deleteTrainer();
                    break;
                case 11:
                    admin.processPayment();
                    break;
                case 12:
                    admin.getPaymentById();
                    break;
                case 13:
                    admin.getAllPayment();
                    break;
                case 14:
                    admin.updatePayment();
                    break;
                case 15:
                    admin.deletePaymentById();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        
        cxt.close();
        scanner.close();
		
	}
}
