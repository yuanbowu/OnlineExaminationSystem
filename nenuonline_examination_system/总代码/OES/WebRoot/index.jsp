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
		<link rel="stylesheet" href="css/synopsis.css" type="text/css" />
		<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="js/getBodyWidAndHei.js" ></script>
	</head>
	<body>
		
		<!-- 介绍考试云的界面 -->
		<div class="title">
		
			<div class="logo">
				
			</div>
			<div class="buttons">
				<a href="loginRegister/login.jsp">登录</a>
				<a href="sign.html">注册</a>
			</div>
		</div>
		<div class="contine">
			
		</div>
	</body>
</html>
