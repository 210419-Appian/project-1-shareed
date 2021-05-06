package com.revature.services;

import java.util.List;

import com.revature.dao.RoleDAO;
import com.revature.dao.RoleDAOImpl;
import com.revature.models.Role;

public class RoleService {
	
	private RoleDAO roleDAO = new RoleDAOImpl();
		
		public List<Role> getAllRoles(){
			return roleDAO.findAll();
		}
	

}
