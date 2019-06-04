package com.oes.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oes.entity.User;
import com.oes.service.UserService;
import com.oes.service.impl.UserServiceImpl;

public class FindPersonServlet extends HttpServlet {
	
	public FindPersonServlet() {
		super();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("管理员", 1);
		map.put("教务", 2);
		map.put("教师", 3);
		map.put("学生", 4);
		
		resp.setContentType("text/html;charset=utf8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("UserName");
		String school = req.getParameter("UserSchool");
		int power = 0;
//		System.out.println("power "+req.getParameter("UserPower"));
//		System.out.println("username "+username);
//		System.out.println("school "+school);
		if( req.getParameter("UserPower") != ""&&req.getParameter("UserPower") != null ){
			power = map.get(req.getParameter("UserPower"));
			System.out.println("newpower"+power);
		}
		
		List<User> list = new ArrayList<User>();
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		int mypower = user.getUserPower();
		String myschool = user.getUserSchool();
		String mygrade = user.getUserGrade();
		String myclass = user.getUserClass();
		
		UserService us = new UserServiceImpl();
		
		switch(mypower){
		case 3:
			list = us.FindPersons(username, myschool, 4, myclass, mygrade);
			session.setAttribute("list", list);
//			System.out.println("servlet "+list);
			resp.sendRedirect("../UserManagement/userAll.jsp");
			
//			req.getRequestDispatcher("/UserManagement/ShowUser.jsp").forward(req, resp);
			return;
		case 2:
			list = us.FindPersons(username, myschool, power, null, null);
			session.setAttribute("list", list);
//			System.out.println("servlet "+list);
			resp.sendRedirect("../UserManagement/userAll.jsp");
//			req.getRequestDispatcher("/UserManagement/ShowUser.jsp").forward(req, resp);
			return;
		case 1:
			list = us.FindPersons(username, school, power, null, null);
			session.setAttribute("list", list);
//			System.out.println("servlet "+list);
			resp.sendRedirect("../UserManagement/userAll.jsp");
//			req.getRequestDispatcher("/UserManagement/ShowUser.jsp").forward(req, resp);
			return;
		}
	}
	
}
