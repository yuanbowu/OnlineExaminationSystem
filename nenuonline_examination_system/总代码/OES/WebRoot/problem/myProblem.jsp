<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="com.oes.entity.SingleChoiceProblem"%>
<%@ page import="com.oes.entity.ExamWithoutTest"%>
<%@ page import ="com.oes.entity.User"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>题库管理</title>
    
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
  <%
	User user = (User) session.getAttribute("user");
	ArrayList<SingleChoiceProblem> SCPList = (ArrayList<SingleChoiceProblem>)request.getAttribute("SCPList");
  %>
  <body>
     您好，<%=user.getUserName()%>, 您提供的题目有<br />
   	 <%
   	 	int sz = SCPList.size();
   	 	for(int i = 0; i < sz; ++i){
   	 		SingleChoiceProblem SCP = SCPList.get(i);
   	 		out.print("<form action=\"servlet/deleteSCPServlet\" method=\"post\">");
   	 		out.print("<h4>题目" + (i + 1) + "</h4>");
   	 		out.print("题目内容：" + SCP.getContent() + "<br />");
   	 		out.print("选项A：" + SCP.getOptionA() +  "<br />");
   	 		out.print("选项B：" + SCP.getOptionB() +  "<br />");
   	 		out.print("选项C：" + SCP.getOptionC() +  "<br />");
   	 		out.print("选项D：" + SCP.getOptionD() +  "<br />");
   	 		out.print("正确选项：" + SCP.getAnswer() + "<br />");
   	 		out.print("<input type=\"hidden\" name=\"SPid\" value=\"" + SCP.getsPid() + "\">");
   	 		out.print("<input type=\"submit\" value=\"删除题目\"> <br />");
   	 		out.print("</form>");
   	 	}
   	  %>
	<br>
    
    
    <div class="link">
    	<a href="servlet/showAllProblemServlet">返回题库列表</a>
    </div>
    <br />
    
  </body>
</html>
