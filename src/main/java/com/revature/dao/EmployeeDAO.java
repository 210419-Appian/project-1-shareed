package com.revature.dao;

import com.revature.models.User;
import com.sun.tools.javac.util.List;

public interface EmployeeDAO {
	
			//for admins and employees to get users info
			public List<User> getAllUsers();

}
