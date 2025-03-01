package com.Controller;

import java.io.IOException;

import com.dao.RegisterDAO;
import com.studentmodel.RegisterModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/registerr")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		long mobileno=Long.parseLong(request.getParameter("tel"));
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		RegisterModel m=new RegisterModel();
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(mobileno);
		System.out.println(userName);
		System.out.println(password);
		RegisterDAO dao=new RegisterDAO();
		m.setFirstName(firstName);
		m.setLastName(lastName);
		m.setMobileno(mobileno);
		m.setUserName(userName);
		m.setPassword(password);
		String status=dao.insert(m);
		System.out.println(status);
		if(status.equals("Success")) {
			RequestDispatcher rd=request.getRequestDispatcher("Loginmain.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
