package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	private UserDAO userDAO = new UserDAOImpl();
	public boolean createHome(User user) {
		if("Tatum".equals(user.getUsername())) {
			return false;
		} else {
			return userDAO.addUser(user);
		}
	}

}
