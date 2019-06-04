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
    
    <title>考试管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<link rel="stylesheet" type="text/css" href="css/pageManage.css"/>
	<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/getBodyWidAndHei.js" ></script>
	


  </head>
  <body>
		
		<!-- logo和左侧菜单栏 -->
		<div class="navigation">
			<div class="indexLogo">
				
			</div>
			<div class="indexLi">
				<ul class="testUl">
					<li class="examLi"><a href="exam/examOut.jsp">在线考试</a><img src="img/publicSign/右箭头黑.png"></li>
					<li class="userManageLi"><a href="UserManagement/UserManage.jsp" >用户管理</a><img src="img/publicSign/右箭头黑.png"></li>
					<li class="scoreQueryLi"><a href="answer/answerOut.jsp">成绩查询</a><img src="img/publicSign/右箭头黑.png"></li>
					<li class="testQuestionsLi"><a href="problem/problemOut.jsp">题库管理</a><img src="img/publicSign/右箭头黑.png"></li>
					<li class="personManageLi" ><a href="UserManagement/person.jsp" >个人中心</a><img src="img/publicSign/右箭头黑.png"></li>
				</ul>
			</div>
			
		</div>
		<div class="content">
			<!-- 右上侧的头像 -->
			<div class="indexPhoto">
				<div class="photoChose">
					<div class="photo">
						
					</div>
					<button class="indexLogout" onclick="window.location.href='servlet/ExitServlet'">
						退出
					</bustton>
				</div>
			</div>
			<div class="container">
				<div class="blockContainer">
					<div class="pageAll">
						<div class="pageAllContent">
							
							<!-- 教师的试卷管理表格 -->
							<iframe src="servlet/showAllExamServlet"></iframe>
							
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<script src="js/addClass.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
