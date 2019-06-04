<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="com.oes.entity.SingleChoiceProblem"%>
<%@ page import="com.oes.entity.ExamWithoutTest"%>
<%@ page import="com.oes.entity.Answer"%>
<%@ page import="com.oes.entity.AnswerSCP"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
		ExamWithoutTest EOT = (ExamWithoutTest)request.getSession().getAttribute("EOT");
		if(EOT == null) request.getRequestDispatcher("index.jsp");
		Answer ans = (Answer)request.getAttribute("Answer");
	 %>
    <title>
    <% 
    	out.print(EOT.getName());
    %>
    </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/link.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  	<p>
    	<% 
    		out.print(EOT.getName());
    	%>
    </p>
    <p>
    	<% 
    		out.print("举办人id： " + EOT.getOwner());
    	%>
    </p>
    <p>
    	<% 
    		out.print("开始时间： " + EOT.getStartTime());
    	%>
    </p>
    <p>
    	<% 
    		out.print("结束时间： " + EOT.getEndTime());
    	%>
    </p>
    <p>
    	<% 
    		out.print("您的总得分是： " + ans.getScore());
    	%>
    </p>
    
    <%
		ArrayList<SingleChoiceProblem> SCPList = (ArrayList<SingleChoiceProblem>)request.getAttribute("SCPList");
		ArrayList<AnswerSCP> aSCPList = (ArrayList<AnswerSCP>)request.getAttribute("aSCPList");
		int sz = SCPList.size();
		for(int i = 0; i < sz; ++i){
			SingleChoiceProblem SCP = SCPList.get(i);
			AnswerSCP aSCP = aSCPList.get(i);
			out.print("<div>");
			out.println("<h3> 题目 " + (i + 1) + "</h3>");
			out.println("题目内容： " + SCP.getContent() + "<br />");
			out.println("选项A： " + SCP.getOptionA() + "<br />");
			out.println("选项B： " + SCP.getOptionB() + "<br />");
			out.println("选项C： " + SCP.getOptionC() + "<br />");
			out.println("选项D： " + SCP.getOptionD() + "<br />");
			out.println("你的选择是： " + aSCP.getChoice() + "<br />");
			out.println("正确选项是： " + SCP.getAnswer() + "<br />");
			out.println("你的得分是： " + aSCP.getScore() + "<br />");
			out.println("</div>");
		}
	 %>
    <div class="link">
    	<a href="servlet/showAllAnswerServlet">返回答卷列表</a>
    </div>
  </body>
</html>
