package com.revature.bank.services;

import java.util.List;

import com.revature.bank.dao.AccountDAO;
import com.revature.bank.dao.AccountDAOImpl;
import com.revature.bank.dao.EmployeeDAO;
import com.revature.bank.dao.EmployeeDAOImpl;
import com.revature.bank.models.Account;
import com.revature.bank.models.User;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	public List<User> viewAllUsers() {
		return employeeDAO.getAllUsers();
	}
	
	public List<Account> viewAllAccounts() {
		return accountDAO.getAllAccounts();
	}
}
