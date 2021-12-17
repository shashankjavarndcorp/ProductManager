package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.User;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao service = new UserDaoImpl();
		PrintWriter out = response.getWriter();
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		System.out.println(loginName +" " +password);
		try {
			User user = service.authenticate(loginName, password);
			HttpSession session = request.getSession(false);
			session.setAttribute("user", user);
			if (user != null) {
				request.getRequestDispatcher("productDetail.jsp").forward(request, response);
			} else {
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
