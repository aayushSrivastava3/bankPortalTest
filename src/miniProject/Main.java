package miniProject;

//import java.io.IOException;
import java.util.Scanner;

import miniProjectModels.Account;
import miniProjectModels.AccountsDAO;

public class Main {
	
	static Scanner sc =new Scanner(System.in);
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Welcome to ASTRA international Bank :-)");
			System.out.println("Press 1 to Create a new account");
			System.out.println("Press 2 to Check balance");
			System.out.println("Press 3 to Withdraw money");
			System.out.println("Press 4 to Deposit money");
			System.out.println("Press 5 to Exit the app");
			int in = Integer.parseInt(sc.nextLine());

			if (in == 1) {
				
				// Code for new account
				System.out.println("Creating new account...");
				System.out.println("Please enter your first name: ");
				String f_name= sc.nextLine();
				System.out.println("Please enter your last name: ");
				String l_name= sc.nextLine();
				int acc_no = (int) (Math.random()*100000);
				Account a = new Account(acc_no,f_name,l_name);
				AccountsDAO.insertToDB(a);
				System.out.println("Account Details: ");
				System.out.println(a);

				
			} else if (in == 2) {
				
				// code for check balance
				System.out.println("Checking balance: \nPlease enter account number: ");
				int acc_no= Integer.parseInt(sc.nextLine());
				AccountsDAO.chkBalance(acc_no);
				
			} else if (in == 3) {
				
				// code for withdraw money
				System.out.println("Withdrawing money!....");
				System.out.println("Account Number:");
				int acc_no = Integer.parseInt(sc.nextLine());
				System.out.println("Please enter amount to be withdrawn:");
				double amt = Double.parseDouble(sc.nextLine());
				AccountsDAO.withdraw(acc_no,amt);
				
			} else if (in == 4) {
				
				// code for deposit money
				System.out.println("Depositing money!....");
				System.out.println("Account Number:");
				int acc_no = Integer.parseInt(sc.nextLine());
				System.out.println("Please enter amount to be deposited:");
				double amt = Double.parseDouble(sc.nextLine());
				AccountsDAO.deposit(acc_no,amt);
				
			} else if (in == 5) {
				
				// Exit the application - exit the infinite while loop
				break;
				
			} else {
				// do nothing when else case
			}
			
			// To separate between the loop instances 
			System.out.println("-------------------------------------------");
		}
		System.out.println("Thank you for banking with us!");
	}
}
