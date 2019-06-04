package com.oes.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.dao.AnswerDao;
import com.oes.entity.ExamWithoutTest;
import com.oes.entity.SingleChoiceProblem;
import com.oes.service.AnswerService;
import com.oes.service.ExamService;
import com.oes.service.ProblemService;
import com.oes.service.impl.AnswerServiceImpl;
import com.oes.service.impl.ExamServiceImpl;
import com.oes.service.impl.ProblemServiceImpl;

public class examVerifyServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			ExamWithoutTest EOT = (ExamWithoutTest)req.getSession().getAttribute("EOT");
			
			
			
			String pwd = req.getParameter("pwd");
			if(pwd.equals(EOT.getPassword())){
				req.getRequestDispatcher("/exam/examing.jsp").forward(req, resp);
				return ;
			}
			
			
			String error = "√‹¬Î¥ÌŒÛ";
			req.setAttribute("error", error);
		 	req.getRequestDispatcher("/exam/examingVerify.jsp").forward(req, resp);
		}
}
