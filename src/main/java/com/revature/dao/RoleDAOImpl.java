package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

	@Override
	public List<Role> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sqlQuery = "SELECT * FROM roles;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuery);
			
			List<Role> list = new ArrayList<>();
			int roleId;
			while(result.next()) {
				Role role = new Role();
						role.setRoleId(result.getInt("role_id"));
						role.setRole(result.getString("user_role"));	
						list.add(role);
			}
			return list;
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role findByRoleName(String roleName) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sqlQuery = "SELECT * FROM roles WHERE user_role = ?;";
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.setString(1, roleName);
			
			ResultSet result = statement.executeQuery();
			Role role = new Role();
			while(result.next()) {
				role.setRoleId(result.getInt("role_id"));
				role.setRole(result.getString("user_role"));	
				
			}
				return role;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
