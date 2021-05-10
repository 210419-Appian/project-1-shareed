package com.revature.bank.services;

import java.util.List;

import com.revature.bank.dao.AccountDAO;
import com.revature.bank.dao.AccountDAOImpl;
import com.revature.bank.models.Account;
import com.revature.bank.models.User;

public class AccountService {
	
	private AccountDAO accountDAO = new AccountDAOImpl();

	public List<Account> getAllAccount() {
		return accountDAO.getAllAccounts();
	}


	public int addAccount(Account account) {
			return accountDAO.addAccount(account);

	}
	
	public Account getAccountByAccountId(int id) {
		return accountDAO.getAccountByAccountId(id);
	}
	
	public List<Account> getAccountByAccountStatus(int status_id) {
		return accountDAO.getAccountsByAccountStatus(status_id);
	}
	
	public List<Account> getAccountByAccountUser(int userId) {
		return accountDAO.getAccountsByAccountUser(userId);
	}




}