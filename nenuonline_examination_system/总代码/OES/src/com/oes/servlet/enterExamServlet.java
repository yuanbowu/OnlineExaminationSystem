package com.oes.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.Answer;
import com.oes.entity.ExamWithoutTest;
import com.oes.entity.SingleChoiceProblem;
import com.oes.service.AnswerService;
import com.oes.service.ExamService;
import com.oes.service.ProblemService;
import com.oes.service.impl.AnswerServiceImpl;
import com.oes.service.impl.ExamServiceImpl;
import com.oes.service.impl.ProblemServiceImpl;


public class enterExamServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			int eid = Integer.valueOf(req.getParameter("eid"));
			ExamService eSer = new ExamServiceImpl();
			
			ProblemService pSer = new ProblemServiceImpl();
			ArrayList<SingleChoiceProblem> SCPList = pSer.find(eid);
			
			ExamWithoutTest EOT = eSer.find(eid);
			req.getSession().setAttribute("EOT", EOT);
			
			req.getSession().setAttribute("SCPList", SCPList);
			Timestamp now = new Timestamp((new Date()).getTime());
			
			/*
			System.out.println(now);
			System.out.println(EOT.getStartTime());
			System.out.println(EOT.getEndTime());
			System.out.println(now.before(EOT.getStartTime()));
			System.out.println(now.after(EOT.getEndTime()));
			*/
			
			int Uid = (Integer)req.getSession().getAttribute("Uid");
			int Eid = EOT.getEid();
			AnswerService aSer = new AnswerServiceImpl();
			Answer ans = aSer.verifyUser(Uid, Eid);
			if(ans != null){
				String error = "您已经参加过该次考试";
				req.setAttribute("error", error);
				req.getRequestDispatcher("showAllAnswerServlet").forward(req, resp);
				return;
			}
			
			if(now.before(EOT.getStartTime())) {
				req.getRequestDispatcher("/exam/examNotBegin.jsp").forward(req, resp);
				return;
			}
			else if(now.after(EOT.getEndTime())){
				req.getRequestDispatcher("/exam/examOver.jsp").forward(req, resp);
				return;
			}
			else {
				req.getRequestDispatcher("/exam/examingVerify.jsp").forward(req, resp);
				return;
			}
		}
}
