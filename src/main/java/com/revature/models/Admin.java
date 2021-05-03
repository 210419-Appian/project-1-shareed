package com.revature.models;

public class Admin extends User {
	
	
	public Admin() {
		super();
		
	}

	public Admin(int userId, 
			     String username, 
			     String password, 
			     String firstName, 
			     String lastName, 
			     String email,
			     Role role) {
		
		super(userId, 
			  username, 
			  password, 
			  firstName, 
			  lastName, 
			  email, 
			  role);
		
	}


}
