package com.revature.bank.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bank.controllers.AccountController;
import com.revature.bank.controllers.UserController;
import com.revature.bank.models.Account;
import com.revature.bank.models.User;
import com.revature.bank.models.UserDTO;
import com.revature.bank.services.AccountService;
import com.revature.bank.services.UserService;

public class FrontControllerServlet extends HttpServlet {
	
	private String BaseURL = null;
	private UserController userControl = new UserController();
	private AccountController accountControl = new AccountController();
	
	UserService userService = new UserService();
	AccountService accountService = new AccountService();
	ObjectMapper om = new ObjectMapper();
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		BaseURL = config.getInitParameter("BaseURL");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
res.setContentType("application/json");
		
//		res.setStatus(404); 
		
		final String URL = req.getRequestURI().replace(BaseURL, "");
		
		System.out.println(URL);
		
		
		String[] sections = URL.split("/");
		
		System.out.println(sections);
		
		switch(sections[0]) {
			case "register":
				if(req.getMethod().equals("POST")) {
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
			break;
			case "login":
				if(req.getMethod().equals("POST")) {
					
					BufferedReader reader = req.getReader();
					
					StringBuilder sb = new StringBuilder();
					
					String line = reader.readLine();
					
					while(line != null) {
			            sb.append(line);
			            line= reader.readLine();
			        }
					
					String body = new String(sb);
					
					UserDTO userDTO = om.readValue(body, UserDTO.class);
					
					PrintWriter out = res.getWriter();
					
					
					if(userService.checkLoginData(userDTO)) {
						out.print("{message: ok}");
						HttpSession ses = req.getSession();
						
						User loggedInUser = userService.getUserByUsername(userDTO.username);
						
						ses.setAttribute("userId", loggedInUser.getUserId());
						ses.setAttribute("username", loggedInUser.getUsername());
						ses.setAttribute("role", loggedInUser.getRole().getRole());
						
						res.setContentType("application/json");
						out.print(om.writeValueAsString(loggedInUser));
						
					} else {
						res.setStatus(400);
						out.print("{\"message\": \"Invalid Credentials\"}");
					}
				
				}
			break;
			case "logout":
				HttpSession ses = req.getSession(false);
				
				res.setContentType("application/json");
				PrintWriter out = res.getWriter();
	
				 if (ses != null) {
					String username = (String) ses.getAttribute("username");
					res.setStatus(200);
					out.print("{message:\"You have successfully logged out " + username + "\"}");
					ses.invalidate();
				}else if (ses.equals(null)) {//this is not working
					res.setStatus(400);
				    out.print("{\"message\": \"There was no user logged into the session\"}");
	
				}
			break;
			case "users":
			if(req.getMethod().equals("GET")) {
				if(sections.length == 1) {
					userControl.getAllUsers(req, res);
				}else {
					System.out.println("What are you looking for");
				}
			}
			break;
		
			case "accounts":
			if(req.getMethod().equals("GET")) {
				if(sections.length == 1) {
					accountControl.getAllAccounts(req, res);
				}else if(sections.length == 2) {
					int id = Integer.parseInt(sections[1]);
					

				}
			} else if(req.getMethod().equals("POST")) {
				if(sections.length == 1) {
					
					
					String role = (String) req.getSession().getAttribute("role");
					
					if(role.equals("Admin") || role.equals("Employee")) {
						
						BufferedReader reader = req.getReader();
						
						StringBuilder sb = new StringBuilder();
						
						String line = reader.readLine();
						
						while(line != null) {
				            sb.append(line);
				            line= reader.readLine();
				        }
						
						String body = new String(sb);
						
						Account newAccountInfo = om.readValue(body, Account.class);
						
						int newAccount = accountService.addAccount(newAccountInfo);
						PrintWriter out1 = res.getWriter();
						out1.print(newAccount);
					
				}
				
			}
			break;
			
			}
		}
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
	
	protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getMethod().equals("PATCH")) {
			
		}else {
			super.service(req, resp);
		}
		
	}
}




