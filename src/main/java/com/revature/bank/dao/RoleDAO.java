package com.revature.bank.dao;



import java.util.List;

import com.revature.bank.models.Role;

public interface RoleDAO {
	
		//get all the roles
		List<Role> findAll();
		
		public Role findRoleByRoleId(int roleId);

		//get a single role, you have to pass the primary key
		Role findRoleByRoleName(String roleName);
}
