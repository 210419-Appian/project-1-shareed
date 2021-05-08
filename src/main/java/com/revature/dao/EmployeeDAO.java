package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface EmployeeDAO {
	
	//for admins and employees to get users info
		public List<User> getAllUsers();

}
