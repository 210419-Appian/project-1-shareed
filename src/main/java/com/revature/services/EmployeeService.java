package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.User;

public class EmployeeService {

	
private EmployeeDAO userDAO = new EmployeeDAOImpl();
	
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
}
