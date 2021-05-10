package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.models.Account;
import com.revature.bank.models.User;
import com.revature.bank.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> getAllAccounts() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			AccountTypeDAOImpl accountTypeDAOImpl = new AccountTypeDAOImpl();
			AccountStatusDAOImpl accountStatusDAOImpl = new AccountStatusDAOImpl();
			
			String sqlQuery = "SELECT * FROM account";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sqlQuery);
			
			List<Account> list = new ArrayList<>();
			
			while(result.next()) {
				Account account = new Account(
						result.getInt("account_id"),
						result.getInt("user_id"),
						result.getDouble("balance"),
						accountStatusDAOImpl.findById(result.getInt("status")),
						accountTypeDAOImpl.findById(result.getInt("account_type")));
				list.add(account);
				
			}
			
			return list;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public int addAccount(Account account) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sqlOuery = "INSERT INTO account(user_id, balance, status, account_type)"
					+ "VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sqlOuery);

			
			int index = 0;
			
			statement.setInt(++index, account.getUserId());
			statement.setDouble(++index, account.getBalance());
			statement.setInt(++index, account.getStatus().getStatusId());
			statement.setInt(++index, account.getType().getTypeId());

			statement.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return account.getAccountId();
		
	}
	
	
	
	@Override
	public Account getAccountByAccountId(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			AccountTypeDAOImpl accountTypeDAOImpl = new AccountTypeDAOImpl();
			AccountStatusDAOImpl accountStatusDAOImpl = new AccountStatusDAOImpl();
			
			String sql = "SELECT * FROM account WHERE account_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			Account account = null;
			
			while(result.next()) {
				account = new Account(
						result.getInt("account_id"),
						result.getInt("user_id"),
						result.getDouble("balance"),
						accountStatusDAOImpl.findById(result.getInt("status")),
						accountTypeDAOImpl.findById(result.getInt("account_type")));
				
			}
			
			return account;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}