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
 * Servlet implementation class GetServlet
 */
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long tel = Long.parseLong(request.getParameter("tel"));
		System.out.println("hello");
		System.out.println(tel);
		String mobileCheck = "";
		RegisterModel model = new RegisterModel();
		model.setMobileno(tel);
		RegisterDAO dao = new RegisterDAO();
		boolean mobileIsExists = dao.checkMobile(model);
		System.out.println(mobileIsExists);
		if (mobileIsExists) {
			mobileCheck = "Mobile No. is Already Registered !!";
		}

		response.setContentType("text/plain");
		response.getWriter().write(mobileCheck);

	}

}
