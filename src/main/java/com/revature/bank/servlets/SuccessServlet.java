package com.revature.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet {
	
	//Just to make sure I am logging out successfully
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		//gets a currently active session if one exists.
		HttpSession ses = req.getSession(false);
		
		if (ses == null) {
			out.print("{message:\"YOU ARE NOT LOGGED IN!!!!!!!!\")");
		} else {
			String name = (String) ses.getAttribute("username");
			out.print("message: \"Welcome " + name + "\", you are successfully logged in\"");
		}
		
		
		
	}

}
