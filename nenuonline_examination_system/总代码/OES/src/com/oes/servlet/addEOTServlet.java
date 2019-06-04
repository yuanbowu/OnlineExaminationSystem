package com.oes.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oes.entity.EOTSCP;
import com.oes.entity.ExamWithoutTest;
import com.oes.service.ExamService;
import com.oes.service.impl.ExamServiceImpl;

public class addEOTServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			String name = req.getParameter("Name");
			String password = req.getParameter("Password");
			
			Timestamp startTime = null, endTime = null;
			try {
				startTime = Timestamp.valueOf(req.getParameter("StartTime"));
			} catch (Exception e) {
				// TODO: handle exception
				String error = "开始时间格式错误";
				req.setAttribute("error", error);
				req.getRequestDispatcher("/exam/addExamWithoutTest.jsp").forward(req, resp);
			}
			try {
				endTime = Timestamp.valueOf(req.getParameter("EndTime"));
			} catch (Exception e) {
				// TODO: handle exception
				String error = "结束时间格式错误";
				req.setAttribute("error", error);
				req.getRequestDispatcher("/exam/addExamWithoutTest.jsp").forward(req, resp);
			}

			//System.out.println("### " + startTime + " " + endTime);
			
			int owner = 0;
			if(req.getSession().getAttribute("Uid") == null) owner = 0;
			else owner = (int)req.getSession().getAttribute("Uid");
			ExamService eSer = new ExamServiceImpl();
			ExamWithoutTest EOT = new ExamWithoutTest(name, password, startTime, endTime, owner);
			int eid = eSer.addExamWithoutTest(EOT);
			
			int tot = 1;
			while(req.getParameter("Problem" + tot) != null){
				int sPid = Integer.valueOf(req.getParameter("Problem" + tot));
				EOTSCP ep = new EOTSCP(sPid, eid, tot, 5);
				eSer.addEOTSCP(ep);
				++tot;
			}

			//System.out.println(" Content " + Content + " OptionA " + OptionA + " Answer " + Answer);
			
		 	req.getRequestDispatcher("/servlet/showAllExamServlet").forward(req, resp);
		}

}
