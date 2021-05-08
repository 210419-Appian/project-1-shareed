package com.revature.bank.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bank.models.User;
import com.revature.bank.models.UserDTO;
import com.revature.bank.services.UserService;

public class LoginServlet extends HttpServlet {
	
		UserService userService = new UserService();
		ObjectMapper om = new ObjectMapper();
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
			
			
			if(userService.checkLoginData(userDTO)) {//if you successfully login
				out.print("{message: ok}");
				HttpSession ses = req.getSession();
				
				User loggedInUser = userService.getUserByUsername(userDTO.username);
				
				ses.setAttribute("username", loggedInUser.getUsername());
				ses.setAttribute("role", loggedInUser.getRole().getRole());
				res.setContentType("application/json");
				out.print(om.writeValueAsString(loggedInUser));
				
			} else {
				res.setStatus(404);
				out.print("{message: INVALID CREDENTIALS}");//added to body of response
			}

		}

}
