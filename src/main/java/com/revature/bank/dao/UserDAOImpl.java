package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.bank.models.Role;
import com.revature.bank.models.User;
import com.revature.bank.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private static RoleDAO  roleDAO = new RoleDAOImpl();

	@Override
	public User addUser(User user) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sqlQuery = "INSERT INTO users(user_name, user_password, first_name, last_name, email, user_roleid)"
								+ "VALUES(?,?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			
			int index = 0;
			
			statement.setString(++index, user.getUsername());
			statement.setString(++index, user.getPassword());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getEmail());
			
			if(user.getRole() != null) {
				statement.setInt(++index, user.getRole().getRoleId());
			} else {
				statement.setString(++index, null);
			}
			
			statement.execute();
			
			
			} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public User findUserByUserId(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE user_id = " + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			User user = null;

			while (result.next()) {
				user = new User(
						result.getInt("user_id"), 
						result.getString("user_name"), 
						result.getString("first_name"), 
						result.getString("last_name"), 
						result.getString("user_password"), 
						result.getString("email"),
						null
						);
				//try to see if this works by adding it to the end of the user object
				Integer roleId = result.getInt("user_roleid");
				if(roleId != null) {
					user.setRole(roleDAO.findRoleByRoleId(roleId));
				}
				
			}
			
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public User findUserByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sqlQuery = "SELECT * FROM users WHERE user_name = ?";

			PreparedStatement statement = conn.prepareStatement(sqlQuery);

			statement.setString(1, username);
			
			ResultSet result = statement.executeQuery();

			User user = null;

			while (result.next()) {
				user = new User(
						result.getInt("user_id"), 
						result.getString("user_name"), 
						result.getString("first_name"), 
						result.getString("last_name"), 
						result.getString("user_password"), 
						result.getString("email"),
						null
						);
				//try to see if this works by adding it to the end of the user object
				Integer roleId = result.getInt("user_roleid");
				if(roleId != null) {
					user.setRole(roleDAO.findRoleByRoleId(roleId));
				}
				
			}
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public User updateUser(User user) {
	try(Connection conn = ConnectionUtil.getConnection()) {
				
				String sqlQuery = "UPDATE users SET user_name = ?, user_password = ?, first_name = ?, "
									+ "last_name = ?, email = ?, user_roleid = ?";
								
				PreparedStatement statement = conn.prepareStatement(sqlQuery);
				
				int index = 0;
				
				
				statement.setString(++index, user.getUsername());
				statement.setString(++index, user.getPassword());
				statement.setString(++index, user.getFirstName());
				statement.setString(++index, user.getLastName());
				statement.setString(++index, user.getEmail());
				
				if(user.getRole() != null) {
					statement.setInt(++index, user.getRole().getRoleId());
				} else {
					statement.setInt(++index, 0);
				}
				
				statement.execute();
				
				return user;
				
				} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
}





	
}
