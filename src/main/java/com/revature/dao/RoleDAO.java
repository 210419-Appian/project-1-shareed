package com.revature.dao;

import com.revature.models.Role;
import com.sun.tools.javac.util.List;

public interface RoleDAO {
	
			//get all the roles
			List<Role> findAll();
			
			//get a single role, you have to pass the primary key
			Role findByRoleName(String role);
			

}
