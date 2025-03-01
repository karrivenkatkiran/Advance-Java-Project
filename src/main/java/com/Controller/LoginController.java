package com.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.RegisterDAO;
import com.studentmodel.LoginModel1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		LoginModel1 l=new LoginModel1();
		l.setUserName(userName);
		l.setPassword(password);
		RegisterDAO login = new RegisterDAO();
		String status=login.selectWithLogin(l);
		System.out.println(status);
		ResultSet rs=login.selectProfile(l);
		
		
		if(status.equals("Success") && rs!=null) {
			try {
				if(rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("firstName", rs.getString(1));
					session.setAttribute("lastName", rs.getString(2));
					session.setAttribute("userName", rs.getString(3));
					session.setAttribute("number", rs.getLong(4));
					session.setAttribute("password", rs.getString(5));
					RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("i", 1);
			session.setAttribute("error", "some details are incorrect");
			RequestDispatcher rd=request.getRequestDispatcher("Loginmain.jsp");
			rd.forward(request, response);
		}
	}

}
