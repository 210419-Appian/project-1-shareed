package com.revature.models;

public class Premium extends User{
	
	public Premium (int userId, 
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
