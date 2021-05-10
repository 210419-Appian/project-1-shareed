package com.revature.bank.dao;

import java.util.List;

import com.revature.bank.models.AccountType;

public interface AccountTypeDAO {
	
	public List<AccountType> getAll();
	public AccountType findById(int id);
	public int addItem(AccountType a);
	public boolean removeItemGivenId(int id);
	public boolean update(AccountType a);

}
