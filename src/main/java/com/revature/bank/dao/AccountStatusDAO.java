package com.revature.bank.dao;

import java.util.List;

import com.revature.bank.models.AccountStatus;

public interface AccountStatusDAO {
	
	public List<AccountStatus> getAll();
	
	public AccountStatus findById(int id);
	

}
