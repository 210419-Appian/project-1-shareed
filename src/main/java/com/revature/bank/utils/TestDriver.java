package com.revature.bank.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bank.dao.*;
import com.revature.bank.models.Role;
import com.revature.bank.models.User;
;

public class TestDriver {
	
	public static void main(String[] args) throws IOException {
		
		//This code should go in the controller
		System.out.println("*****************Getting All Users*********************");
		ObjectMapper om = new ObjectMapper();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		List<User> userList = employeeDAO.getAllUsers();
		
		String json = om.writeValueAsString(userList);
		
		System.out.println(json);
		System.out.println("________________________________________________________");
		System.out.println("                                                        ");
		
		System.out.println("*************Getting User By User ID****************");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findUserByUserId(12);
		json = om.writeValueAsString(user);
		System.out.println(json);
		System.out.println("________________________________________________________");
		System.out.println("                                                        ");
		
		System.out.println("*************Getting User By Username****************");
		UserDAO userDAO2 = new UserDAOImpl();
		User user2 = userDAO2.findUserByUsername("ShannonTheGreat");
		json = om.writeValueAsString(user2);
		System.out.println(json);
		System.out.println("________________________________________________________");
		System.out.println("                                                        ");
		
		System.out.println("*************Adding A User****************");
		UserDAO userDAO3 = new UserDAOImpl();
		User user3 = new User("CR", "chrispassword", "Chrisi", "Rock", "chris@email.com", new Role(1, "Admin") );
		userDAO3.addUser(user3);
		json = om.writeValueAsString(user3);
		System.out.println(json);
		
		
//		PrintWriter pw = resp.getWriter();
//		
//		pw.print(json);
//		
//		resp.setStatus(200);
				
	}

}
