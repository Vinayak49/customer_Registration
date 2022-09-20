package com.hotwa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hotwax.model.UserObjects;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partyId = request.getParameter("PartyId");
		int pid = Integer.parseInt(partyId);
		UserObjects userObjects = new UserObjects();
		
		try {
			
			boolean b=userObjects.deleteRecord(pid);
			if (b==true){
				response.sendRedirect("allrecords.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
