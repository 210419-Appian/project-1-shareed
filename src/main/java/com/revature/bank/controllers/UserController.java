package com.revature.bank.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
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

//
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		PrintWriter out = res.getWriter();
//		
//		String role = (String) req.getSession().getAttribute("role");
//		
//		if(role.equals("Admin")) {
//			
//			BufferedReader reader = req.getReader();
//			
//			StringBuilder sb = new StringBuilder();
//			
//			String line = reader.readLine();
//			
//			while(line != null) {
//	            sb.append(line);
//	            line= reader.readLine();
//	        }
//			
//			String body = new String(sb);
//			
//			User newUserInfo = om.readValue(body, User.class);
//			
//			User newUser = userService.createUser(newUserInfo);
//			
//			if(newUser != null) {
//				res.setStatus(201);
//				res.setContentType("application/json");
//				out.print(om.writeValueAsString(newUser));
//			} else {
//				res.setStatus(422);
//				res.setContentType("application/json");
//				out.print("{\"message\":\"User could not be created\"}");
//			}
//			
//			} else {
//				res.setStatus(401);
//				res.setContentType("application/json");
//				out.print("{\"message\":\"The requested action is no permitted\"}");
//			}
//		
//		
//		}
//	
//	
//	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//				Integer userId = (Integer) req.getSession().getAttribute("userId");
//				String role = (String) req.getSession().getAttribute("role");
//				PrintWriter out = res.getWriter();
//				
//				out.print(userId);
//				out.print(role);
//				
//				res.setStatus(404); //default if someone sends a malformed request. 
//				
//				final String URL = req.getRequestURI().replace(UpdateURL, "");
//				
//				System.out.println(URL);
//	
//				
//				String[] sections = URL.split("/");
//				
//				System.out.println(sections);
//				
//				switch(sections[0]) {
//				case "user":
//					if(sections.length == 2) {
//						//check to see if the userid off params matches
//						//user id off session
//						int id = Integer.parseInt(sections[1]);
//						if(id == userId || role.equals("Admin")) {
//							BufferedReader reader = req.getReader();
//							
//							StringBuilder sb = new StringBuilder();
//							
//							String line = reader.readLine();
//							
//							while(line != null) {
//								sb.append(line);
//								line = reader.readLine();
//								
//							}
//							
//							String body = new String(sb);
//							User user = om.readValue(body, User.class);
//								if(userService.updateUser(user)) {
//									res.setStatus(200);
//									out.print("{\"message\":\"User has been updated\"}");
//								} else {
//									res.setStatus(400);
//								}
//									out.print("{\"message\":\"Something went wrong\"}");
//								}
//					} else {
//						res.setStatus(400);
//						out.print("{\"message\":\"You do not have access to change this user\"}");
//					}
//				}
//		}
						
	}