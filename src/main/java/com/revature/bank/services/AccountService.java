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



}