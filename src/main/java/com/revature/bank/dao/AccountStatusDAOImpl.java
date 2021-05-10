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

	


}
