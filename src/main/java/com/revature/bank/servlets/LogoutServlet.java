package com.revature.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LogoutServlet extends HttpServlet {
	
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses = req.getSession(false);
		String username = (String) ses.getAttribute("username");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();

		if (ses != null) {
			res.setStatus(200);
			out.print("{message:\"You have successfully logged out {username}\" + username)");
			ses.invalidate();
		} 
//		else {//this is not working
//			res.setStatus(400);
//			out.print("{\"message\": \"There was no user logged into the session\"}");
//			
//			
//		}
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
