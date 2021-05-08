package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
	
	private UserService employeeService = new UserService();
	private UserService userService = new UserService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllUsers(HttpServletResponse resp) throws IOException {
		List<User> list = employeeService.viewAllUsers();

		String json = om.writeValueAsString(list);
		
		System.out.println(json);
		
		PrintWriter pw = resp.getWriter();
		
		pw.print(json);
		
		resp.setStatus(200);
	}
	
	public void getUser(HttpServletResponse resp, int id) throws IOException{
			
			User a = userService.getOneUser(id);
					
	
			// Convert Java object into a JSON string that can be written to the body of an
			// HTTP response
			String json = om.writeValueAsString(a);
			System.out.println(json);
			PrintWriter pw = resp.getWriter();
			pw.print(json);
			resp.setStatus(200);
		}


}
