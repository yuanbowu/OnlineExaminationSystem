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
    
    <title>My JSP 'examAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/pageAll.css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/link.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="" cellspacing="" cellpadding="">
    	<tr style="position: sticky; top: 0px; background-color: white;">
    		<td>考试编号</td>
    		<td>考试名称</td>
    		<td>开始时间</td>
    		<td>结束时间</td>
    		<td>举办人</td>
    		<td>进入考试</td>
    	</tr>
    	<%
    		ArrayList<ExamWithoutTest> EOTList = (ArrayList<ExamWithoutTest>)request.getSession().getAttribute("EOTList");
    		int sz = EOTList.size();
    		for(int i = 0; i < sz; ++i){
    			ExamWithoutTest EOT = EOTList.get(i);
    			out.println("<tr>");
	    		out.println("<td>" + EOT.getEid() + "</td>");
	    		out.println("<td>" + EOT.getName() + "</td>");
	    		out.println("<td>" + EOT.getStartTime() + "</td>");
	    		out.println("<td>" + EOT.getEndTime() + "</td>");
	    		out.println("<td>" + EOT.getOwner() + "</td>");
	    		out.println("<td><form action=\"servlet/enterExamServlet\" method=\"post\"><input type=\"hidden\" value=\"" + EOT.getEid() + "\" name=\"eid\"><input type=\"submit\" value=\"进入考试\">");
	    		out.println("</form></td>");
	    		out.println("</tr>");
    		}

    	 %>
    </table>
    <div class="link">
    	<a href="exam/addExamWithoutTest.jsp">自定义考试</a>
    </div>
    
  </body>
</html>
