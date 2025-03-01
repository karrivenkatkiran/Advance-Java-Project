package com.Controller;

import java.io.IOException;
import java.util.List;

import com.dao.RegisterDAO;
import com.studentmodel.RegisterModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		long mobileno = Long.parseLong(request.getParameter("tel"));
		String userName = request.getParameter("username");
		RegisterModel rm= new RegisterModel();
		rm.setFirstName(firstName);
		rm.setLastName(lastName);
		rm.setMobileno(mobileno);
		rm.setUserName(userName);
		RegisterDAO r = new RegisterDAO();
		boolean status = r.updateAllByAdmin(rm);
		List<RegisterModel> list = r.getAll();
		if(status) {
			HttpSession session=request.getSession();
			session.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("AdminUpdate.jsp");
			rd.forward(request, response);
		}
	}

}
