package com.oes.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oes.entity.User;
import com.oes.service.UserService;
import com.oes.service.impl.UserServiceImpl;

public class UpdateInformationServlet extends HttpServlet {

	public UpdateInformationServlet() {
		super();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf8");
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		int power = user.getUserPower();
		int sign;
		User userInfo = new User(user.getUid(), req.getParameter("UserName"),
				req.getParameter("UserPwd"), power, req.getParameter("UserSchool"),
				req.getParameter("UserGrade"),req.getParameter("UserClass"), req.getParameter("UserSex"), 
				req.getParameter("UserTel"), req.getParameter("UserAdr"), req.getParameter("Introduction"));		
		UserService us = new UserServiceImpl();
		boolean flag = us.UpdatePersonalInformation(userInfo);
		session.setAttribute("user", userInfo);
		
		resp.sendRedirect("../UserManagement/person.jsp");
		
	}	

}
