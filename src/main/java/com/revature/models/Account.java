package com.revature.models;

public class Account {
	
	private int accountId;
	private double balance;
	private AccountStatus status;
	private AccountType type;
	
	
	
	
	public Account() {
		super();
	}


	public Account(int accountId, double balance, AccountStatus status, AccountType type) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}
	
	
	public void printAccountInfo() {
		System.out.println("Account Id: " + accountId);
		System.out.println("Account Balance: " + balance);
		System.out.println("Account Status: " + status.getStatus());
		System.out.println("Account Type: " + type.getType());
		
	}
	
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public AccountStatus getStatus() {
		return status;
	}
	
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public void setType(AccountType type) {
		this.type = type;
	}

}
