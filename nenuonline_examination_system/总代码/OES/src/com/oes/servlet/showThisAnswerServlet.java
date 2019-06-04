package com.oes.servlet;

import java.awt.Choice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.Answer;
import com.oes.entity.AnswerSCP;
import com.oes.entity.ExamWithoutTest;
import com.oes.entity.SingleChoiceProblem;
import com.oes.service.AnswerService;
import com.oes.service.ExamService;
import com.oes.service.ProblemService;
import com.oes.service.impl.AnswerServiceImpl;
import com.oes.service.impl.ExamServiceImpl;
import com.oes.service.impl.ProblemServiceImpl;

public class showThisAnswerServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			int Uid = (Integer)req.getSession().getAttribute("Uid");
			int Eid = Integer.valueOf(req.getParameter("Eid"));
			AnswerService aSer = new AnswerServiceImpl();
			ProblemService pSer = new ProblemServiceImpl();
			ArrayList<SingleChoiceProblem> SCPList = new ArrayList<SingleChoiceProblem>();
			ArrayList<AnswerSCP> aSCPList = aSer.findAllAnswerSCP(Uid, Eid);
			
			ExamService eSer = new ExamServiceImpl();
			ExamWithoutTest EOT = eSer.find(Eid);
			req.getSession().setAttribute("EOT", EOT);
			
			Answer ans = aSer.verifyUser(Uid, Eid);
			req.setAttribute("Answer", ans);
			
			int sz = aSCPList.size();
			for(int i = 0; i < sz; ++i){
				AnswerSCP aSCP = aSCPList.get(i);
				SingleChoiceProblem SCP = pSer.findSCPProblem(aSCP.getSPid());
				SCPList.add(SCP);
			}
			req.setAttribute("SCPList", SCPList);
			req.setAttribute("aSCPList", aSCPList);
			
		 	req.getRequestDispatcher("/answer/examAnswer.jsp").forward(req, resp);
		 	
		}
}
