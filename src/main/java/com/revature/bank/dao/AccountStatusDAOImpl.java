package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.models.AccountStatus;
import com.revature.bank.utils.ConnectionUtil;

public class AccountStatusDAOImpl implements AccountStatusDAO {
	
	@Override
	public List<AccountStatus> getAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM account_status";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<AccountStatus> myList = new ArrayList<>();
			
			while(result.next()) {
				AccountStatus myAccountStatus = new AccountStatus(
						result.getInt("status_id"),
						result.getString("status"));
				myList.add(myAccountStatus);
				
			}
			return myList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AccountStatus findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM account_status WHERE status_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			AccountStatus myAccountStatus = new AccountStatus();
			
			while(result.next()) {
				myAccountStatus.setStatusId(result.getInt("status_id"));
				myAccountStatus.setStatus(result.getString("status"));
			}
			return myAccountStatus;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addItem(AccountStatus a) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO account_status (status) "
					+ "VALUES (?)";
			
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			int index = 0;
			statement.setString(++index, a.getStatus());
			
			statement.execute();
			
			ResultSet myResultSet = statement.getGeneratedKeys();
			
			myResultSet.next();
			
			return myResultSet.getInt("status_id");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean removeItemGivenId(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM account_status WHERE status_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setInt(++index, id);
			
			statement.execute();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(AccountStatus a) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE account_status SET status = ? WHERE status_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, a.getStatus());
			statement.setInt(++index, a.getStatusId());
			
			statement.execute();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
