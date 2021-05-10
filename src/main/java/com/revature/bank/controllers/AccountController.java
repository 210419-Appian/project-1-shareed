package com.revature.bank.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bank.models.Account;
import com.revature.bank.services.AccountService;
import com.revature.bank.services.EmployeeService;

public class AccountController {
	
	ObjectMapper om = new ObjectMapper();
	AccountService userService = new AccountService();
	
	public void getAllAccounts(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			EmployeeService employeeService = new EmployeeService();
			PrintWriter out = res.getWriter();
			
			String role = (String) req.getSession().getAttribute("role");
			
			if(role == null) {
				
				out.print("<h1>YOU DO NOT HAVE ACCESS TO VIEW ALL USERS</h1>");
				
			} else if(role.equals("Admin") || role.equals("Employee")) {
				
				List<Account> accountList = employeeService.viewAllAccounts();
				String json = om.writeValueAsString(accountList);
				out.print(json);
			} 
			
	}
	
	public void getAccountsByAccountId(HttpServletRequest req, HttpServletResponse res, int id) throws ServletException, IOException {
			
			AccountService employeeService = new AccountService();
			PrintWriter out = res.getWriter();
			
			String role = (String) req.getSession().getAttribute("role");
			Integer userId = (Integer) req.getSession().getAttribute("userId");
			
			if(role == null) {
				out.print("<h1>YOU DO NOT HAVE ACCESS TO VIEW THIS ACCOUNT</h1>");
				
			} else if(role.equals("Admin") || role.equals("Employee") || userId.equals(id)) {
				Account userAccount = employeeService.getAccountByAccountId(id);
				String json = om.writeValueAsString(userAccount);
				out.print(json);
			} 
			
		}
	
	
	public void getAccountByAccountStatus(HttpServletRequest req, HttpServletResponse res, int status_id) throws ServletException, IOException {
			
			AccountService accountService = new AccountService();
			PrintWriter out = res.getWriter();
			
			String role = (String) req.getSession().getAttribute("role");
			
			if(role == null) {
				out.print("<h1>YOU DO NOT HAVE ACCESS TO VIEW THIS ACCOUNT</h1>");
			} else if(role.equals("Admin") || role.equals("Employee")) {
	
				List<Account> statusAccount = accountService.getAccountByAccountStatus(status_id);
				String json = om.writeValueAsString(statusAccount);
				out.print(json);
			} 
			
		}


	public void getAccountByAccountUser(HttpServletRequest req, HttpServletResponse res, int user_id) throws ServletException, IOException {
		
		AccountService accountService = new AccountService();
		PrintWriter out = res.getWriter();
		
		String role = (String) req.getSession().getAttribute("role");
		Integer currentUserId = (Integer) req.getSession().getAttribute("userId");
		
		if(role == null) {
			out.print("<h1>YOU DO NOT HAVE ACCESS TO VIEW THIS ACCOUNT</h1>");
		} else if(role.equals("Admin") || role.equals("Employee") || currentUserId.equals(user_id)) {
	
			List<Account> userAccounts = accountService.getAccountByAccountUser(user_id);
			String json = om.writeValueAsString(userAccounts);
			out.print(json);
		} 
		
	}
	
	
	public void deposit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	
	public void transfer(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
	}
	
	public void withdraw(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	
	


}
