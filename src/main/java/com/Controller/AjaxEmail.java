package com.Controller;

import java.io.IOException;

import com.dao.RegisterDAO;
import com.studentmodel.RegisterModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxEmail
 */
@WebServlet("/AjaxEmail")
public class AjaxEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegisterModel model = new RegisterModel();
		RegisterDAO dao = new RegisterDAO();
		String gmailCheck = "";
		String userName = request.getParameter("username");
		System.out.println(userName);
		model.setUserName(userName);
		boolean unIsExists = dao.checkUserName(model);
		if (unIsExists) {
			gmailCheck = "Username is Already Registered !!";
		}
		response.setContentType("text/plain");
		response.getWriter().write(gmailCheck);

	}

}
