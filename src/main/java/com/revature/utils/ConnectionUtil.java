package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
		
		String url = "jdbc:postgresql://appian-210419.cicsaqdn7n8c.us-east-2.rds.amazonaws.com:5432/bankapi";
		String username = "postgres";
		String password = "password";
		
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
	public static void main(String [] args) {
	/*
	 * Finally block are so commonly used to close resources(open connections outside of Java)
	 * that there is a short cut to creating a finally block that does it called a `try with resources block`
	 * that declares the resource to open and then close at(inside the curly braces) the try declaration
	 */
	
	try(Connection conn = ConnectionUtil.getConnection()) {//try to establish a connection
		System.out.println("Connection Successful");//if connection successful
	} catch(SQLException e) {//if exception, catch exception and show the exception
		e.printStackTrace();
	}
}

}
