package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.models.UserDTO;

public class UserService {
	
	private UserDAO userDAO = new UserDAOImpl();
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	private UserDTO userLogin = new UserDTO();
	
	public List<User> viewAllUsers() {
		return employeeDAO.getAllUsers();
	}
	
	public User getOneUser(int id) {
		return userDAO.findUserByUserId(id);
	}
	
	public User getUserByUsername(String username) {
		return userDAO.findUserByUsername(username);
				
	}
	
	public boolean checkLoginInfo(UserDTO userData) {
		User user = getUserByUsername(userData.username);
		
		boolean loggedIn = false;
		
		if(user != null && userData.password.equals(user.getPassword())) {
			loggedIn = true;
			
		}
		return loggedIn;
	}


}
