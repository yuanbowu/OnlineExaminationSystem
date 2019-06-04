<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="com.oes.entity.SingleChoiceProblem"%>

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
	
	<link rel="stylesheet" type="text/css" href="css/pageAll.css"/>
	<link rel="stylesheet" type="text/css" href="css/link.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="" cellspacing="" cellpadding="">
    	<tr style="position: sticky; top: 0px; background-color: white;">
    		<td>题目编号</td>
    		<td>题目内容</td>
    		<td>题目作者</td>
    		<td>提供时间</td>
    		<td>选项A</td>
    		<td>选项B</td>
    		<td>选项C</td>
    		<td>选项D</td>
    		<td>正确答案</td>
    	</tr>
    	
		<c:forEach items="${SCPList}" var="tSCP">
			<tr>
				<td>${tSCP.sPid}</td>
				<td>${tSCP.content}</td>
				<td>${tSCP.owner}</td>
				<td>${tSCP.provideTime}</td>
				<td>${tSCP.optionA}</td>
				<td>${tSCP.optionB}</td>
				<td>${tSCP.optionC}</td>
				<td>${tSCP.optionD}</td>
				<td>${tSCP.answer}</td>
			</tr>
		</c:forEach>
    </table>
	<br>

    <br />
    <div class="link">
    	<a href="problem/addSingleChoiceProblem.jsp">添加单选题</a> 
    	<a href="servlet/showMyProblemServlet">我的试题</a>
    </div>
    
    <br />
    
  </body>
</html>
