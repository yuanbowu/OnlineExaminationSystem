package com.oes.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oes.entity.User;
import com.oes.service.ImportService;
import com.oes.service.impl.ImportServiceImpl;

public class ImportExcelServlet extends HttpServlet {

	public ImportExcelServlet() {
		super();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf8");
		req.setCharacterEncoding("utf-8");
//		String path = req.getParameter("path");
		String path = "C:\\Users\\Explorer\\Desktop\\test1.xlsx";
//		System.out.println("path "+path);
		//String path = "C:\\Users\\Explorer\\Desktop\\test1.xlsx";
		ImportService is = new ImportServiceImpl();
		List<User> list = is.AnalysisExcel(path);
		boolean flag = is.ImportExcel(list);
		if( flag==true ){
			resp.sendRedirect("../UserManagement/UserManage.jsp");
		}else{
			resp.sendRedirect("../UserManagement/addUser.jsp");

		}
	}
	
	
	
	
	
	
	
	

	
	
	

	
}
