package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	
	private UserDAO userDAO = new UserDAOImpl();
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	public List<User> viewAllUsers() {
		return employeeDAO.getAllUsers();
	}
	
	public User getOneUser(int id) {
		return userDAO.findById(id);
	}
	


}
