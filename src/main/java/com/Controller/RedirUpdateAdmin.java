package com.Controller;

import java.io.IOException;
import java.sql.ResultSet;


import com.dao.RegisterDAO;
import com.studentmodel.RegisterModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatePage")
public class RedirUpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		RegisterModel rm = new RegisterModel();
		rm.setUserName(username);
		RegisterDAO r = new RegisterDAO();
		try {
			ResultSet rs= r.selectProfile(rm);
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("firstName", rs.getString(1));
				session.setAttribute("lastName", rs.getString(2));
				session.setAttribute("userName", rs.getString(3));
				session.setAttribute("number", rs.getLong(4));

				RequestDispatcher rd= request.getRequestDispatcher("AdminUpdate.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd= request.getRequestDispatcher("AdminHome.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
