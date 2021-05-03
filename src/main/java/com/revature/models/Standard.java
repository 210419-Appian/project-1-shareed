package com.revature.models;

public class Standard extends User {
	
	
	
	public Standard() {
		super();
		
	}

	public Standard (int userId, 
				     String username, 
				     String password, 
				     String firstName, 
				     String lastName, 
				     String email,
				     Role role)  {

					super(userId, 
						  username, 
						  password, 
						  firstName, 
						  lastName, 
						  email, 
						  role);

}

}
