package com.oes.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.ExamWithoutTest;
import com.oes.service.ExamService;
import com.oes.service.impl.ExamServiceImpl;


public class showAllExamServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			ExamService eSer = new ExamServiceImpl();
			ArrayList<ExamWithoutTest> EOTList = eSer.findAllExam();
			
			req.getSession().setAttribute("EOTList", EOTList);
			// System.out.println(EOTList.size());
		 	req.getRequestDispatcher("/exam/examList.jsp").forward(req, resp);
		 	
		}
}
