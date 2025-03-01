package com.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import com.dao.RegisterDAO;
import com.studentmodel.RegisterModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UpdateController1")
public class UpdateController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		long mobileno = Long.parseLong(request.getParameter("tel"));
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		RegisterModel model = new RegisterModel();
		model.setUserName(userName);
		model.setFirstName(firstName);
		model.setLastName(lastName);
		model.setMobileno(mobileno);
		model.setPassword(password);
		RegisterDAO dao = new RegisterDAO();
		boolean update = dao.updateAll(model);
		System.out.println(update);

		if (update) {
			try {
				ResultSet rs = dao.selectProfile(model);
				if (rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("firstName", rs.getString(1));
					session.setAttribute("lastName", rs.getString(2));
					session.setAttribute("userName", rs.getString(3));
					session.setAttribute("number", rs.getLong(4));
					session.setAttribute("password", rs.getString(5));

					response.sendRedirect("home.jsp");
				}
			}

			catch (Exception e) {
				System.out.println(e);
			}
		} else {
			response.sendRedirect("updatePage.jsp");
		}
	}

}
