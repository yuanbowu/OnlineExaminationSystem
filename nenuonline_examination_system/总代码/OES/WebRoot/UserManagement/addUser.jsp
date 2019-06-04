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
		<link rel="stylesheet" type="text/css" href="../css/index.css"/>
		<link rel="stylesheet" type="text/css" href="../css/addStudent.css"/>
		<link rel="stylesheet" type="text/css" href="../css/userManage.css"/>
		<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
		<script src="../js/addFile.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/oneButton.js" type="text/javascript" charset="utf-8"></script>
		
	</head>
	<body>
		<!-- logo 和侧栏 -->
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
			<!-- 头像 -->
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
				<!-- 上传方式 -->
				<div class="addChoose">
					<label for="fileinp">
							<input type="button" id="btn" value="点我上传"><div id="text"></div>
							<input type="file" id="fileinp" accept=".xls,.xlsx">
					</label>
					<br/>
					<input type="button" name="" id="oneAdd" value="单个添加" />
				</div>
				
				<!-- 添加用户的信息 -->
				<div class="oneAddContent">
					<form id="oneAddForm" action="../servlet/ImportUserServlet" method="post">
						学校：<input type="text" name="UserSchool" id="UserSchool" value="" required />
						密码：<input type="password" name="UserPwd" id="UserPwd" value="" required /><br/>
						年级：<input type="text" name="UserGrade" id="" value="" required />
						身份：<select name="UserPower" id="UserPower" required>
							
							<option value="教师" >教师</option>
							<option value="学生" >学生</option>
							<option value="管理员" >管理员</option>
						</select>
						<br/>
						姓名：<input type="text" name="UserName" id="UserName" value="" required / ><input type="tel" name="UserTel" id="UserTel" value="" /><br/>
						班级：<input type="text" name="UserClass" id="UserClass" value="" required />
						<input type="submit"  id="addStudentForm" value="提交" />
					</form>
				</div>

			</div>
		</div>
		<script src="../js/addFile.js" type="text/javascript" charset="utf-8"></script>
		
	</body>
</html>

