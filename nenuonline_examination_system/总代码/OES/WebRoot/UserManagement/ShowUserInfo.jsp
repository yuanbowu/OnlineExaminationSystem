<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import ="com.oes.entity.User"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/index.css"/>
		<link rel="stylesheet" type="text/css" href="../css/person.css"/>
		<link rel="stylesheet" type="text/css" href="../css/indexNew.css"/>
		<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="../js/getBodyWidAndHei.js" ></script>
	</head>
	<%
		User user = (User) session.getAttribute("user");
		User Useruser = (User) session.getAttribute("Useruser");
		int power = user.getUserPower();
		String sign = "";
		if( power<4 ){
			sign = "none"; 
		}
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "管理员");
		map.put(2, "教务");
		map.put(3, "教师");
		map.put(4, "学生");
	 %>
	<body>
		<div class="navigation">
			<div class="indexLogo">
				
			</div>
			<div class="indexLi">
				<ul class="testUl">
					<li class="examLi"><a href="../exam/examOut.jsp">在线考试</a><img src="../img/publicSign/右箭头黑.png"></li>
					<li class="userManageLi"><a href="UserManage.jsp" >用户管理</a><img src="../img/publicSign/右箭头黑.png"></li>
					<li class="scoreQueryLi"><a href="../answer/answerOut.jsp">成绩查询</a><img src="../img/publicSign/右箭头黑.png"></li>
					<li class="testQuestionsLi"><a href="../problem/problemOut.jsp">题库管理</a><img src="../img/publicSign/右箭头黑.png"></li>
					<li class="personManageLi" ><a href="person.jsp" >个人中心</a><img src="../img/publicSign/右箭头黑.png"></li>
				</ul>
			</div>
		</div>
		<div class="content">
			<div class="indexPhoto">
				<div class="photoChose">
					<div class="photo">
						
					</div>
					<button class="indexLogout" onclick="window.location.href='../servlet/ExitServlet'">
						退出
					</bustton>
				</div>
			</div>
			<div class="container">
				<div class="information">
					<div class="personInfor">
						<div class="IDInform">
							
							<!-- 头像 -->
							<div class="headImg">
								<img src="../img/publicSign/头像.png" >
							</div>
							
							<!-- 姓名和身份 -->
							<div class="informName">
								<p><%=Useruser.getUserName() %></p>
								<p><%=map.get(Useruser.getUserPower()) %></p>
							</div>
						</div>
						
						<!-- 个人的各种信息 -->
						<div class="schoolInform">
							<table border="" cellspacing="" cellpadding="">
								<tr><td class="inforTitle">学校:</td><td class="inforValue"><%=Useruser.getUserSchool() %></td></tr>
								<tr><td class="inforTitle">学号:</td><td class="inforValue">2017036478</td></tr>
								<tr><td class="inforTitle">姓名:</td><td class="inforValue"><%=Useruser.getUserName() %></td></tr>
								<tr><td class="inforTitle">年级:</td><td class="inforValue"><%=Useruser.getUserGrade() %></td></tr>
								<tr><td class="inforTitle">班级:</td><td class="inforValue"><%=Useruser.getUserClass() %></td></tr>
								<tr><td class="inforTitle">电话:</td><td class="inforValue"><%=Useruser.getUserTel() %></td></tr>
								<tr><td class="inforTitle">住址:</td><td class="inforValue"><%=Useruser.getUserAdr() %></td></tr>
								<tr><td class="inforTitle">简介:</td><td class="inforValue"><%=Useruser.getIntroduction() %></td></tr>
							</table>
							
							<!-- 修改信息 -->
							<button type="button" onclick="window.location.href='changeUserInfo.jsp'">修改信息</button>
						</div>
						
					</div>
				</div>
				
				<!-- 红黄蓝绿四大板块 -->
				<div class="allNumber" style="display: <%=sign %>" >
					<div class="allNumberBlock">
						<div class="questionNum">
							<p>已做题目</p>
						</div>
						<div class="testNum">
							<p>已完成考试</p>
						</div>
						<div class="wrongNum">
							<p>错题库</p>
						</div>
						<div class="readyNum">
							<p>待完成考试</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

