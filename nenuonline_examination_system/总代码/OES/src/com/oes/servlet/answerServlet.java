package com.oes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.Answer;
import com.oes.entity.AnswerSCP;
import com.oes.entity.SingleChoiceProblem;
import com.oes.service.AnswerService;
import com.oes.service.impl.AnswerServiceImpl;


public class answerServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			AnswerService aSer = new AnswerServiceImpl();
			Answer Ans = new Answer();
			int eid = Integer.valueOf(req.getParameter("Eid"));
			
			Ans.setExam(eid);
//			System.out.println("Eid: " + eid);
			int tot = 1, Uid = 0, score = 0;
			
			if(req.getSession().getAttribute("Uid") != null) Uid = (Integer)req.getSession().getAttribute("Uid");
			Ans.setOwner(Uid);
//			System.out.println("Uid: " + Uid);
			
			while(req.getParameter("Answer" + tot) != null){
				String ans = req.getParameter("Answer" + tot);
				String choice = req.getParameter("Choice" + tot);
				int sPid = Integer.valueOf(req.getParameter("sPid" + tot));
				AnswerSCP aSCP;
				if(ans.equals(choice)){
					score += 5;
					aSCP = new AnswerSCP(sPid, Uid, choice, 5, eid);
				}else{
					aSCP = new AnswerSCP(sPid, Uid, choice, 0, eid);
				}
				aSer.addAnswerSCP(aSCP);
				++tot;
			}
			Ans.setScore(score);
			aSer.addAnswerPaper(Ans);
			// System.out.println("Score: " + score);
		 	req.getRequestDispatcher("showAllAnswerServlet").forward(req, resp);
		}
}
