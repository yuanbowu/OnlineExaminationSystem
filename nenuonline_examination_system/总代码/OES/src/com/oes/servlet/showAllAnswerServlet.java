package com.oes.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.Answer;
import com.oes.service.AnswerService;
import com.oes.service.impl.AnswerServiceImpl;

public class showAllAnswerServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			int Uid = (Integer)req.getSession().getAttribute("Uid");
			AnswerService aSer = new AnswerServiceImpl();
			ArrayList<Answer> aList = aSer.findAllAnswer(Uid);
			
			req.setAttribute("AnswerList", aList);
			
		 	req.getRequestDispatcher("/answer/answerList.jsp").forward(req, resp);
		 	
		}
}
