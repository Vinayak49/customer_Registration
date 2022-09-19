package com.hotwa.controller;

import java.io.IOException;
import java.security.Key;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotwax.model.User;
import com.hotwax.model.UserObjects;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String country = request.getParameter("country");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		Encoder encoder =  Base64.getEncoder();
		String encodedpswd = encoder.encodeToString(password.getBytes());
		
		User user = new User();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		user.setCountry(country);
		user.setPhone(phone);
		user.setUserId(userid);
		user.setPassword(encodedpswd);
		
		UserObjects userObject = new UserObjects();
		
		userObject.addUser(user);
		
		request.setAttribute("status", "success");
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("SignUp.jsp");
		dispatcher.forward(request, response);

	}

}
