package com.revature.bank.services;

import java.util.List;

import com.revature.bank.dao.AccountStatusDAO;
import com.revature.bank.dao.AccountStatusDAOImpl;
import com.revature.bank.models.AccountStatus;


public class AccountStatusService {
	
	private AccountStatusDAO myAccountStatusDAO = new AccountStatusDAOImpl();

	public List<AccountStatus> getAllAccountStatus() {
		return myAccountStatusDAO.getAll();
	}

	public AccountStatus getAccountStatusById(int id) {
		return myAccountStatusDAO.findById(id);
	}


}
