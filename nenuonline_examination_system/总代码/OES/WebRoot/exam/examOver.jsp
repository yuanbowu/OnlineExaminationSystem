<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="com.oes.entity.SingleChoiceProblem"%>
<%@ page import="com.oes.entity.ExamWithoutTest"%>
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
    	考试已经结束
    </p>
    <div class="link">
    	<a href="servlet/showAllExamServlet">返回考试列表</a>
    </div>
  </body>
</html>
