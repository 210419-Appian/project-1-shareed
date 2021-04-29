package com.revature.main;

import com.revature.models.Admin;
import com.revature.models.Role;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Role myUserRole = new Role(12345, "Customer");
		User myUser = new Admin(1, "CodeBeater", "ILoveToCode", "Shannon", "Reed", "shann@email.com", myUserRole);

		
		/****************************************************************************************************************
		 * FOR TESTING 
		 ****************************************************************************************************************/
		
		myUser.printUserInfo();
		
	}

}
