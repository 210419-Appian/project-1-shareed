package com.revature.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bank.services.EmployeeService;
import com.revature.bank.models.User;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		EmployeeService employeeService = new EmployeeService();
		PrintWriter out = res.getWriter();

		//res.setContentType("application/json");//Check and see if i need this
		String role = (String) req.getSession().getAttribute("role");

		
		if(role == null) {
			out.print("<h1>YOU DO NOT HAVE ACCESS TO VIEW ALL USERS</h1>");
		} else if(role.equals("Admin") || role.equals("Employee")) {
			List<User> userList = employeeService.viewAllUsers();
			String json = om.writeValueAsString(userList);
			out.print(json);
		} 
		
	}
}
