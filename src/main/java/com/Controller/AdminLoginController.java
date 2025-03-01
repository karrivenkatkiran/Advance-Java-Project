package com.Controller;

import java.io.IOException;
import java.util.List;

import com.dao.RegisterDAO;
import com.studentmodel.LoginModel1;
import com.studentmodel.RegisterModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		LoginModel1 l = new LoginModel1();
		l.setUserName(userName);
		l.setPassword(password);
		RegisterDAO login = new RegisterDAO();
		String status = login.adminLogin(l);
		List<RegisterModel> list = login.getAll();
		if(status.equals("Success")) {
			HttpSession session=request.getSession();
			session.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);
		}
	}

}
