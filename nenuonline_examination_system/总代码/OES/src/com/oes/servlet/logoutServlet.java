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

public class logoutServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		session.setAttribute("Uid", null);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}
