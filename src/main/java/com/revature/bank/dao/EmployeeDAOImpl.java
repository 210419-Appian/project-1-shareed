package com.revature.bank.dao;

import com.revature.bank.models.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.utils.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static RoleDAO  roleDAO = new RoleDAOImpl();

	@Override
	public List<User> getAllUsers() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sqlQuery = "SELECT * FROM users;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuery);
			List<User> list = new ArrayList<>();
			
			while(result.next()) {
				User u = new User(
						result.getInt("user_id"),
						result.getString("user_name"),
						result.getString("user_password"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("email"),
						null
						);
				String roleName = result.getString("user_role");
				if(roleName != null) {
					u.setRole(roleDAO.findByRoleName(roleName));
				}
				list.add(u);
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
