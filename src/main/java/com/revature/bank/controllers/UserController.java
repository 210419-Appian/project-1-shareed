package com.revature.bank.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bank.models.User;
import com.revature.bank.services.EmployeeService;
import com.revature.bank.services.UserService;

public class UserController {
	ObjectMapper om = new ObjectMapper();
	UserService userService = new UserService();
	
	public void getAllUsers(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeService();
		PrintWriter out = res.getWriter();

		String role = (String) req.getSession().getAttribute("role");

		
		if(role == null) {
			out.print("<h1>YOU DO NOT HAVE ACCESS TO VIEW ALL USERS</h1>");
		} else if(role.equals("Admin") || role.equals("Employee")) {
			List<User> userList = employeeService.viewAllUsers();
			String json = om.writeValueAsString(userList);
			out.print(json);
		} 
		
	}
	
	public void getUser(HttpServletResponse res, int id) throws  IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(userService.getUser(id));
	}

	
	
	public void getUserById(HttpServletRequest req, HttpServletResponse res, int id) throws ServletException, IOException {
		UserService userService = new UserService();
		PrintWriter out = res.getWriter();

		String role = (String) req.getSession().getAttribute("role");
		Integer currentUserId = (Integer) req.getSession().getAttribute("userId");

		
		if(role == null) {
			out.print("<h1>YOU DO NOT HAVE ACCESS TO VIEW ALL USERS</h1>");
		} else if(role.equals("Admin") || role.equals("Employee") || currentUserId.equals(id)) {
			User user = userService.getUser(id);
			String json = om.writeValueAsString(user);
			out.print(json);
		} 
	}

						
	}