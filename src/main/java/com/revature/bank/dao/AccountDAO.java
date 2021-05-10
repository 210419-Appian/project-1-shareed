package com.revature.bank.dao;

import java.util.List;

import com.revature.bank.models.Account;
import com.revature.bank.models.User;

public interface AccountDAO {
	
	public int addAccount(Account account);
	
	public List<Account> getAllAccounts();

	Account getAccountByAccountId(int id);

}
