package miniProjectConnections;

import java.sql.*;

// JDBC connection
// In this class we will define the connection properties 
public class Connect {
	
	// We will store the connection in a variable - con 
	static Connection con;
	
	//we will make a method which when called will create a connection
	public static Connection CreateConnection() throws SQLException {
				
		try {
			//load the driver class 
			//Initializing driver class - looks for driver class and calls it 
			//
			Class.forName("com.mysql.cj.jdbc.Driver");  // will have exception therefore in try catch block 
			
			//Create the connection - Connection properties 
			String url="jdbc:mysql://localhost:3306/accounts";
			String username="root";
			String password="password@123";
			
			//we have the URL of the database, username and password 
			//we will create a connection and store it in a variable con
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// we will return the connection 
		return con;
	}
}
