package com.oes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oes.entity.*;

import com.oes.service.UserService;
import com.oes.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
//		System.out.println(username+"  "+password);
		UserService us = new UserServiceImpl();
		User user = us.LoginService(username, password);
//		System.out.println	("dadada");
		if(user == null){
			
			req.getRequestDispatcher("/loginRegister/login.jsp").forward(req, resp);
			
			return;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		session.setAttribute("Uid", user.getUid());
		int power = user.getUserPower();
//		switch( power ){
//		case 1:
//			resp.sendRedirect("../UserManagement/AdminMainPage.jsp");
//			return;
//		case 2:
//			resp.sendRedirect("../UserManagement/AffairsMainPage.jsp");
//			return;
//		case 3:
//			resp.sendRedirect("../UserManagement/TeacherMainPage.jsp");
//			return;
//		case 4:
//			resp.sendRedirect("../UserManagement/StudentMainPage.jsp");
//			return;
//		}
		resp.sendRedirect("../UserManagement/person.jsp");
		return;
	}
	
}
