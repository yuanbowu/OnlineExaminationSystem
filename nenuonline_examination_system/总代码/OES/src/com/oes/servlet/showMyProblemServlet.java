package com.oes.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.SingleChoiceProblem;
import com.oes.service.ProblemService;
import com.oes.service.impl.ProblemServiceImpl;

public class showMyProblemServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			int Uid = (int) req.getSession().getAttribute("Uid");
			ProblemService pSer = new ProblemServiceImpl();
			ArrayList<SingleChoiceProblem> SCPList = pSer.findSomeProblem(Uid);
			
			req.setAttribute("SCPList", SCPList);
		 	req.getRequestDispatcher("/problem/myProblem.jsp").forward(req, resp);
		 	
		}
}
