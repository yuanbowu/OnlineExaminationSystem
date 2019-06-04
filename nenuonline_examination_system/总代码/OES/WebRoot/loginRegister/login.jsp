<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="../css/synopsis.css" type="text/css" />
		<link rel="stylesheet" type="text/css" href="../css/login.css"/>
		<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="../js/getBodyWidAndHei.js" ></script>
	</head>
	<body>
		
		<!-- logo和登录注册按钮 -->
		<div class="title">
		
			<div class="logo">
				
			</div>
			<div class="buttons">
				<a href="login.html">登录</a>
				<a href="sign.html">注册</a>
			</div>
		</div>
		
		<div class="contine">
			
			<div class="signForm">
				<div class="signTitle">
					<p>登录</p>
				</div>
				
				<!-- 错误提示处 -->
				<div id="wrong">
					<p>密码设置错误，请重新设置</p>
				</div>
				<form action="../servlet/LoginServlet" method="get">
					<!-- <input id="school" list="school" name="school" placeholder="请输入学校">
						<datalist id="school">
							<option value="东北师范大学">
							<option value="东北大学">
							<option value="吉林大学">
							<option value="重庆大学">
							<option value="武汉大学">
						</datalist> -->
					<input type="text" id="signStudentNumber" name = "username" placeholder="请输入考试云用户名">
					<input type="password" id="signStudentPassword" name = "password"  placeholder="请输入考试云账号密码">
					<input type="submit" id="loginSubmit" value="登录"/>
				</form>
			</div>
		</div>
	</body>
</html>

