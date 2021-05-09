package com.revature.bank.dao;

import com.revature.bank.models.Role;
import com.revature.bank.models.User;

public interface UserDAO {
	
			//add user/ register
			User addUser(User user);
			
			public User findUserByUserId(int id);
			
			//get current user
			public User findUserByUsername(String username);
			
			//update current user
			public boolean updateCurrentUserInfo(User user);
			
			
			
}
