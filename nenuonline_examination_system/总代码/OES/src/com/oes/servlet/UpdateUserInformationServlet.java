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

public class UpdateUserInformationServlet extends HttpServlet {

	public UpdateUserInformationServlet() {
		super();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset:utf8");
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("管理员", 1);
		map.put("教务", 2);
		map.put("教师", 3);	
		map.put("学生", 4);
		HttpSession session = req.getSession();
		
		User Useruser = (User)session.getAttribute("Useruser");
		
		
		User user = new User();
		user.setUid(Useruser.getUid());
		user.setUserName(req.getParameter("UserName"));
		user.setUserPwd(req.getParameter("UserPwd"));
		user.setUserPower(map.get(req.getParameter("UserPower")));
		user.setUserSchool(req.getParameter("UserSchool"));
		user.setUserGrade(req.getParameter("UserGrade"));
		user.setUserClass(req.getParameter("UserClass"));
//		System.out.println("Useuser Uid "+Useruser.getUid());
		UserService us = new UserServiceImpl();
		us.UpdateUserInformation(user);
		
		resp.sendRedirect("../UserManagement/UserManage.jsp");
		
	}
	
}
