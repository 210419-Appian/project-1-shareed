package com.revature.bank.dao;

import com.revature.bank.models.User;

public interface AdminDAO {
	
	//for admin to update user information
	public boolean updateUser(User user);
	

}
