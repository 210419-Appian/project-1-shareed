package com.revature.bank.services;

import java.util.List;

import com.revature.bank.dao.AccountTypeDAO;
import com.revature.bank.dao.AccountTypeDAOImpl;
import com.revature.bank.models.AccountType;

public class AccountTypeService {

	
	private AccountTypeDAO myAccountTypeDAO = new AccountTypeDAOImpl();


	public AccountType getAccountTypeById(int id) {
		return myAccountTypeDAO.findById(id);
	}


}
