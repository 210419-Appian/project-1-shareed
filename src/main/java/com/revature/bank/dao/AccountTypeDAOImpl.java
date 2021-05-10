package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.models.AccountType;
import com.revature.bank.utils.ConnectionUtil;

public class AccountTypeDAOImpl implements AccountTypeDAO{

	@Override
	public AccountType findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sqlQuery = "SELECT * FROM account_type WHERE type_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			AccountType accountType = new AccountType();
			
			while(result.next()) {
				accountType.setTypeId(result.getInt("type_id"));
				accountType.setType(result.getString("account_type"));
			}
			
			return accountType;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	
}
