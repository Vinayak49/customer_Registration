package com.hotwa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hotwax.model.User;
import com.hotwax.model.UserObjects;

/**
 * Servlet implementation class UpdateRecord
 */
@WebServlet("/update")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int partyid =Integer.parseInt(request.getParameter("partyid"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip =Integer.parseInt(request.getParameter("zip"));
		String country = request.getParameter("country");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher ;
		
		User user = new User();
		user.setPartyid(partyid);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		user.setCountry(country);
		user.setPhone(phone);
		user.setUserId(userid);
		user.setPassword(password);
		
		UserObjects userObject = new UserObjects();
		try {
			userObject.updateRecordPost(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("status", "success");
		dispatcher = request.getRequestDispatcher("allrecords.jsp");
		dispatcher.forward(request, response);
	}

}
