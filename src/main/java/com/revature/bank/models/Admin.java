package com.revature.bank.models;

public class Admin extends Employee {
	
	
	public Admin() {
		super();
		
	}

	public Admin(int userId, String username, String password, 
			     String firstName, String lastName, String email,Role role) {
		
		super(userId, username, password, firstName, 
			  lastName, email, role);
		
	}
	
	
}
