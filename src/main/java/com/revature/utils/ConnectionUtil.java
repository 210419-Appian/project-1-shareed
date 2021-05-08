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
		
		
		String url = "jdbc:postgresql://appian-210419.cicsaqdn7n8c.us-east-2.rds.amazonaws.com:5432/bank";
		String username = "postgres";
		String password = "password";
		
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
//	public static void main(String [] args) {
//
//		try(Connection conn = ConnectionUtil.getConnection()) {
//			System.out.println("Connection Successful");
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
