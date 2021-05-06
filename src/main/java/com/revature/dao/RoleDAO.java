package com.revature.dao;

import java.util.List;

import com.revature.models.Role;

public interface RoleDAO {
	
			//get all the roles
			List<Role> findAll();
			
			//get a single role, you have to pass the primary key
			Role findByRoleName(String role);
			

}
