package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean addUser(User user) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sqlQuery = "INSERT INTO users (username, user_password, first_name, last_name, email)"
								+ "VALUES(?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			int index = 0;
			
			statement.setString(++index, user.getUsername());
			statement.setString(++index, user.getPassword());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getEmail());
//			statement.setString(++index, user.getEmail());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean getCurrentUserInfo(User user) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

	

}
