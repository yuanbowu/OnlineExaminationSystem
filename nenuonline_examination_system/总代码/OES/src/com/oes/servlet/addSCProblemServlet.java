package com.oes.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.SingleChoiceProblem;
import com.oes.service.ProblemService;
import com.oes.service.impl.ProblemServiceImpl;


public class addSCProblemServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		//System.out.println("dadada123");
		//System.out.println("dadada123");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String content = req.getParameter("Content");
		String optionA = req.getParameter("OptionA");
		String optionB = req.getParameter("OptionB");
		String optionC = req.getParameter("OptionC");
		String optionD = req.getParameter("OptionD");
		String answer = req.getParameter("Answer");
		//System.out.println(" Content " + Content + " OptionA " + OptionA + " Answer " + Answer);
		
		int owner = 0;
		if(req.getSession().getAttribute("Uid") == null) owner = 0;
		else owner = (int)req.getSession().getAttribute("Uid");
		//System.out.println(Owner);
		Date provideTime = new Date();
		//System.out.println(ProvideTime);
		SingleChoiceProblem SCP = new SingleChoiceProblem(content, owner, provideTime, optionA, optionB, optionC, optionD, answer);
		ProblemService pSer = new ProblemServiceImpl();
		pSer.addSingleChoiceProblem(SCP);
		
	 	req.getRequestDispatcher("/servlet/showAllProblemServlet").forward(req, resp);
	}
}

