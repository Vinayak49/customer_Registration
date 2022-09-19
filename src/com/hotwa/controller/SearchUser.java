package com.hotwa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotwax.model.UserObjects;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/search")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		
		UserObjects userObjects = new UserObjects();
		try {
			ResultSet rs = userObjects.searchUser(firstName,lastName);
			if(rs.next()){
				request.setAttribute("partyId", rs.getString("partyId"));
				request.setAttribute("fname", rs.getString("firstName"));
				request.setAttribute("lname", rs.getString("lastName"));
				request.setAttribute("address", rs.getString("address"));
				request.setAttribute("city", rs.getString("city"));
				request.setAttribute("zip", rs.getString("zip"));
				request.setAttribute("state", rs.getString("state"));
				request.setAttribute("country", rs.getString("country"));
				request.setAttribute("phone", rs.getString("phone"));
				request.setAttribute("password", rs.getString("password"));
				request.getRequestDispatcher("searchResult.jsp").forward(request, response);
			}
			else{
				out.print("No user Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
