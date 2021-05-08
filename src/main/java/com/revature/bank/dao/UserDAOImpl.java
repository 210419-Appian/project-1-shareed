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
	public boolean addUser(User user) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sqlQuery = "INSERT INTO users(user_name, user_password, first_name, last_name, email, user_role)"
								+ "VALUES(?,?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			
			int index = 0;
			
			statement.setString(++index, user.getUsername());
			statement.setString(++index, user.getPassword());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getEmail());
			if(user.getRole() != null) {
				statement.setString(++index, user.getRole().getRole());
			} else {
				statement.setString(++index, null);
			}
			statement.execute();
			return true;
			
			} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public User findUserByUserId(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE user_id = "+id+";";

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
				String roleName = result.getString("user_role");
				if(roleName != null) {
					user.setRole(roleDAO.findByRoleName(roleName));
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
				String roleName = result.getString("user_role");
				if(roleName != null) {
					user.setRole(roleDAO.findByRoleName(roleName));
				}
				
			}
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean updateCurrentUserInfo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String register(String username, String password, String firstName, String lastName, String email,
			Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(String username, String password) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
