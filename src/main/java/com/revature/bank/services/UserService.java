package com.revature.bank.services;

import com.revature.bank.dao.UserDAO;
import com.revature.bank.dao.UserDAOImpl;
import com.revature.bank.models.User;
import com.revature.bank.models.UserDTO;

public class UserService {
	
	private UserDAO userDAO = new UserDAOImpl();
	
	public User createUser(User user) {
		Integer role_id = user.getRole().getRoleId();
		if(role_id > 0 && role_id < 5 ) {
			return userDAO.addUser(user);
		}
		return null;
		
				
	}
	
	public User getUser(int id) {
		return userDAO.findUserByUserId(id);
	}
	
	public User getUserByUsername(String username) {
		return userDAO.findUserByUsername(username);
				
	}
	
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}
	
	public boolean checkLoginData(UserDTO userDTO) {
		User checkedUser = getUserByUsername(userDTO.username);
		
		boolean loginSuccessful = false;
		
		if(checkedUser != null && userDTO.password.equals(checkedUser.getPassword())) {
			loginSuccessful = true;
		} 
			return loginSuccessful;
		
	}
	
	

	
}
