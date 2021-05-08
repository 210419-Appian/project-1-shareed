package com.revature.bank.models;

public class Employee extends User {
	
	
	public Employee() {
		super();
		
	}

	public Employee(int userId, 
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
