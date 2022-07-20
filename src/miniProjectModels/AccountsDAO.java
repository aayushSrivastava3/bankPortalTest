package miniProjectModels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import miniProjectConnections.Connect;

//DAO - we will code all the methods to be called in the main function 
public class AccountsDAO {
	
	//Methos to put values into database
	public static void insertToDB(Account acc) {
		try {
			
			//Calling connection - to establish connection to db 
			Connection con = Connect.CreateConnection();
			
			//SQL query
			String s="insert into accounts(account_no,first_name,last_name) values(?,?,?)";
			
			// We will use prepared statement - dynamic query 
			PreparedStatement ps = con.prepareStatement(s);
			
			//setting values 
			ps.setLong(1, acc.getAccount_no());	 //Getters used - to fetch data from object created
			ps.setString(2, acc.getFirst_name());
			ps.setString(3, acc.getLast_name());
			
			//EXECUTE 
			//Since the query is not returning - execute update
			ps.executeUpdate(); //returns the number of rows effected 
			//ps.executeQuery(); -- this will not work since our query does not return result set  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Code for checking balance 
	public static void chkBalance(int acc_no) {
		
		try {
			//making connection 
			Connection con = Connect.CreateConnection();
			
			//Query
			String s="select balance from accounts where account_no=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, acc_no);
			
			//Since query is returning some output - execute query
			ResultSet r = ps.executeQuery();
			//Printing the values of result set
			while(r.next()) {
				double bal = r.getDouble(1);
				System.out.println("Current closing balance is : "+bal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	// Code for withdraw
	public static void withdraw(int acc_no, double amt) {
		
		try {
			//making connection 
			Connection con = Connect.CreateConnection();
			
			//Query
			String s="select balance from accounts where account_no=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, acc_no);
			
			ResultSet r = ps.executeQuery();
			//Printing the values of result set
			while(r.next()) {
				//applying logic
				double bal = r.getDouble(1);
				bal -= amt;
				System.out.println(amt+" amount withdrawn from account no: "+acc_no +" | current balance is: "+ bal);
				
				//updating database
				String s1="update accounts set balance=? where account_no=?";
				PreparedStatement ps1 = con.prepareStatement(s1);
				ps1.setDouble(1, bal);
				ps1.setInt(2, acc_no);
				
				//Execute
				ps1.executeUpdate();
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void deposit(int acc_no, double amt) {
		try {
			//making connection 
			Connection con = Connect.CreateConnection();
			
			//Query
			String s="select balance from accounts where account_no=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, acc_no);
			
			ResultSet r = ps.executeQuery();
			//Printing the values of result set
			while(r.next()) {
				//applying logic
				double bal = r.getDouble(1);
				bal += amt;
				System.out.println(amt+" amount deposited into account no: "+acc_no+" | current balance is: "+ bal);
				
				//updating database
				String s1="update accounts set balance=? where account_no=?";
				PreparedStatement ps1 = con.prepareStatement(s1);
				ps1.setDouble(1, bal);
				ps1.setInt(2, acc_no);
				
				//Execute
				ps1.executeUpdate();
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
