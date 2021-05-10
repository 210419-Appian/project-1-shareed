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


}
