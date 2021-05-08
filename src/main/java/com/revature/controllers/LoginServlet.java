package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.services.UserService;

public class LoginServlet extends HttpServlet{
		
		private ObjectMapper om = new ObjectMapper();
		private UserService userService = new UserService();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			BufferedReader reader = req.getReader();
			String line = reader.readLine();
			StringBuilder sb = new StringBuilder();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
				
			}
			
			String body = new String(sb);
			UserDTO userDTO = om.readValue(body, UserDTO.class);
			PrintWriter pw = resp.getWriter();
			
			if(userService.checkLoginInfo(userDTO)) {
				HttpSession ses = req.getSession();
				
				User user = userService.getUserByUsername(userDTO.username);
				
				ses.setAttribute("username", user.getUsername());
				ses.setAttribute("password", user.getPassword());
				
				
				resp.setContentType("application/json");
				
				
				pw.print(om.writeValueAsString(user));
				
			}else {
				resp.setStatus(400);
				resp.setContentType("application/json");
				pw.print("{\"message\": \"Invalid Credentials\"}");
				
			}
//			
//			u.username = req.getParameter("userId");
//			u.password = req.getParameter("password");
			
//			//next the userDTO should be passed to the service layer to check if the credentials are accurate. 
//			
//			RequestDispatcher rd = null; 
//			PrintWriter out = resp.getWriter();
//			
//			if(u.username.equals("tom") && u.password.equals("jerry")) {
//				//Create a session so we remember our user/client in the future. 
//				HttpSession ses = req.getSession(); //cookie is created here and put in the response. 
//				ses.setAttribute("username", u.username); //Here we save the username in the session for use later. 
//				
//				rd = req.getRequestDispatcher("success");
//				rd.forward(req, resp);
//			} else {
//				rd = req.getRequestDispatcher("index.html");
//				rd.include(req, resp);
//				out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
//			}
//			
			//resp.setStatus(200); //Tomcat will do this by default if it finds a servlet method to handle the request. 
			
		}
		

}
