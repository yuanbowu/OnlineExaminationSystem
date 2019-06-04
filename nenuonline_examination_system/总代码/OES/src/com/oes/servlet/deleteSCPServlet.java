package com.oes.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.SingleChoiceProblem;
import com.oes.service.ProblemService;
import com.oes.service.impl.ProblemServiceImpl;

public class deleteSCPServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
			//System.out.println("dadada123");
			//System.out.println("dadada123");
			
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			int SPid = Integer.valueOf(req.getParameter("SPid"));
			//System.out.println(" Content " + Content + " OptionA " + OptionA + " Answer " + Answer);
			
			ProblemService pSer = new ProblemServiceImpl();
			pSer.deleteSCP(SPid);
			
		 	req.getRequestDispatcher("/servlet/showAllProblemServlet").forward(req, resp);
		}

}
