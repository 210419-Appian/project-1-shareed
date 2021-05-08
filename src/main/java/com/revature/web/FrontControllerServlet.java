package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.UserController;

public class FrontControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private String BaseURL = null;
	private UserController employeeControl = new UserController();
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		BaseURL = config.getInitParameter("BaseURL");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("application/json");
		
		resp.setStatus(404); 
		
		final String URL = req.getRequestURI().replace(BaseURL, "");
		
		System.out.println(URL);

		String[] sections = URL.split("/");
		
		System.out.println(sections);
		
		switch(sections[0]) {
		case "users":
			if(req.getMethod().equals("GET")) {
				if(sections.length == 2) {
					int id = Integer.parseInt(sections[1]);
					employeeControl.getUser(resp, id);
				}else {
					employeeControl.getAllUsers(resp);
				}
					
				}
			}
		
	}
	

}
