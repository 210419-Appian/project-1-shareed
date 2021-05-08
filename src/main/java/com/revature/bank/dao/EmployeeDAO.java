package com.revature.bank.dao;

import com.revature.bank.models.User;

import java.util.List;


public interface EmployeeDAO {
	
	//for admins and employees to get users info
		public List<User> getAllUsers();

}
