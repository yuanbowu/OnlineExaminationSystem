package com.oes.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.User;
import com.oes.service.ImportService;
import com.oes.service.impl.ImportServiceImpl;

public class ImportUserServlet extends HttpServlet {

	public ImportUserServlet() {
		super();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("����Ա", 1);
		map.put("����", 2);
		map.put("��ʦ", 3);	
		map.put("ѧ��", 4);
		
		resp.setContentType("text/html;charset=utf8");
		req.setCharacterEncoding("utf-8");
		String UserName = req.getParameter("UserName");
		String UserPwd = req.getParameter("UserPwd");
		System.out.println("UserName "+req.getParameter("UserName"));
		System.out.println("UserPwd "+req.getParameter("UserPwd"));
		System.out.println("UserPower "+req.getParameter("UserPower"));
		System.out.println("map "+map.get(req.getParameter("UserPower")));
		System.out.println("UserSchool "+req.getParameter("UserSchool"));
		System.out.println("UserGrade "+req.getParameter("UserGrade"));
		System.out.println("UserClass "+req.getParameter("UserClass"));
		User user = new User(UserName, req.getParameter("UserPwd"), map.get(req.getParameter("UserPower")),
				req.getParameter("UserSchool"), req.getParameter("UserGrade"),req.getParameter("UserClass"));
		
		ImportService is = new ImportServiceImpl();
		boolean flag = is.ImportUser(user);
		if( flag==true ){
			resp.sendRedirect("../UserManagement/UserManage.jsp");
		}else{
			resp.getWriter().write("�������ִ���");
		}
		
	}
	
}
