package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dao.RegisterDAO;
import com.studentmodel.LoginModel1;
import com.studentmodel.RegisterModel;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		LoginModel1 m = new LoginModel1();
		m.setUserName(username);
		RegisterDAO r = new RegisterDAO();
		String status = r.adminDelect(m);
		List<RegisterModel> list=r.getAll();
		if(status.equals("Success")) {
			HttpSession session=request.getSession();
			session.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
	}

}
