package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.models.Role;
import com.revature.bank.utils.ConnectionUtil;

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
	public Role findRoleByRoleId(int roleId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sqlOuery = "SELECT * FROM roles WHERE role_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sqlOuery);
			
			statement.setInt(1, roleId);
			
			ResultSet result = statement.executeQuery();
			
			Role myRole = new Role();
			
			while(result.next()) {
				myRole.setRoleId(result.getInt("role_id"));
				myRole.setRole(result.getString("user_role"));
			}
			
			return myRole;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
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
