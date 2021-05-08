package com.revature.dao;

import com.revature.models.Role;
import com.revature.models.User;

public interface UserDAO {
	
			//add user
			boolean addUser(User user);
			
			public User findUserByUserId(int id);
			
			//get current user
			public User findUserByUsername(String username);
			
			//update current user
			public boolean updateCurrentUserInfo(User user);
			
			//register
			public String register(String username, 
								   String password,
								   String firstName,
								   String lastName,
								   String email,
								   Role role);
			
			//login
			public String login(String username, String password);

}
