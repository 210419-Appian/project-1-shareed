package com.revature.bank.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bank.services.EmployeeService;
import com.revature.bank.services.UserService;
import com.revature.bank.models.User;

public class UserServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();
	UserService userService = new UserService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
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



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String role = (String) req.getSession().getAttribute("role");
		
		if(role.equals("Admin")) {
			
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
	            sb.append(line);
	            line= reader.readLine();
	        }
			
			String body = new String(sb);
			
			User newUserInfo = om.readValue(body, User.class);
			
			User newUser = userService.createUser(newUserInfo);
			
			if(newUser != null) {
				res.setStatus(201);
				res.setContentType("application/json");
				out.print(om.writeValueAsString(newUser));
			} else {
				res.setStatus(422);
				res.setContentType("application/json");
				out.print("{\"message\":\"User could not be created\"}");
			}
			
			} else {
				res.setStatus(401);
				res.setContentType("application/json");
				out.print("{\"message\":\"The requested action is no permitted\"}");
			}
		
		
		}
	
	
		protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			Integer userId = (Integer) req.getSession().getAttribute("userId");
			String role = (String) req.getSession().getAttribute("role");
			PrintWriter out = res.getWriter();
			
			out.print(userId);
			
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
				
			}
			
			String body = new String(sb);
			User user = om.readValue(body, User.class);
			
			if(userId.equals(user.getUserId()) || role.equals("Admin")) {
				res.setStatus(200);
				out.print("{\"message\":\"You have access to change this user\"}");
			} else {
				res.setStatus(400);
				out.print("{\"message\":\"You do not have access to change this user\"}");
			}
		}
}
