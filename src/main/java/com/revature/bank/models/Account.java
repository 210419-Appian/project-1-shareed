package com.revature.bank.models;

public class Account  {
	
	private int accountId;
	private int userId;
	private double balance;
	private AccountStatus status;
	private AccountType type;
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(int accountId, int userId, double balance, AccountStatus status, AccountType type) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}
	
	
	

	public Account(int userId, double balance, AccountStatus status, AccountType type) {
		super();
		this.userId = userId;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + userId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", balance=" + balance + ", status=" + status
				+ ", type=" + type + "]";
	}


	public void printAccountInfo() {
		System.out.println("Account Id: " + accountId);
		System.out.println("Account Balance: " + balance);
		System.out.println("Account Status: " + status.getStatus());
		System.out.println("Account Type: " + type.getType());
		
	}
	
	
	
}
