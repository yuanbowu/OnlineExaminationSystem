package com.oes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oes.entity.User;
import com.oes.service.UserService;
import com.oes.service.impl.UserServiceImpl;

public class findbyUid extends HttpServlet {

	public findbyUid() {
		super();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf8");
		req.setCharacterEncoding("utf-8");
		
		int Uid = Integer.parseInt(req.getParameter("Uid"));
		
		UserService us = new UserServiceImpl();
		User user = us.FindUserByUid(Uid);
		HttpSession session = req.getSession();
		System.out.println("UserName "+user.getUserName());
		session.setAttribute("Useruser", user);
		resp.sendRedirect("../UserManagement/ShowUserInfo.jsp");
		
	}

}
