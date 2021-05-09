package com.revature.bank.services;

import java.util.List;

import com.revature.bank.dao.EmployeeDAO;
import com.revature.bank.dao.EmployeeDAOImpl;
import com.revature.bank.models.User;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	public List<User> viewAllUsers() {
		return employeeDAO.getAllUsers();
	}

}
