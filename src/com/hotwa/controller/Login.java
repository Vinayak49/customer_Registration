package com.hotwa.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hotwax.model.User;
import com.hotwax.model.UserObjects;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		String userid = request.getParameter("userId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		UserObjects userObjects = new UserObjects();
		Encoder encoder =  Base64.getEncoder();
		String encodedpswd = encoder.encodeToString(password.getBytes());
		User user = userObjects.loginUser(userid, encodedpswd);
		
		if(user == null){
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		request.setAttribute("status", "success");
		dispatcher = request.getRequestDispatcher("index.jsp");
		
		session.setAttribute("name", user.getFirstName());
		
		dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

}
