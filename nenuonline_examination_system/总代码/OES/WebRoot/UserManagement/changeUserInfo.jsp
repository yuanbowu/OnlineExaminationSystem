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
		<link rel="stylesheet" type="text/css" href="../css/changeInformation.css"/>
		<link rel="stylesheet" type="text/css" href="../css/indexNew.css"/>
		<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
		
		
	</head>
	<%
		User user = (User) session.getAttribute("user");
		User Useruser = (User) session.getAttribute("Useruser");
		System.out.println("Useruser "+Useruser.getUserName());
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
				
				<!-- 个人信息修改,不能改的信息没有光标显示 -->
				<div class="oneAddContent">
					<form id="oneAddForm" action="../servlet/UpdateUserInformationServlet" method="post">
						学校：<input type="text" name="UserSchool" id="UserSchool" value=<%=Useruser.getUserSchool() %> required />
						密码：<input type="password" name="UserPwd" id="UserPwd" value=<%=Useruser.getUserPwd() %> required /><br/>
						学号：<input type="text" name="" id="Uid" value="2017012453" readonly="readonly" required />
						身份：<input type="text" name="UserPower" id="Uid" value=<%=map.get(Useruser.getUserPower()) %>  required />
						<br/>
						姓名：<input type="text" name="UserName" id="UserName" value=<%=Useruser.getUserName() %> required / >
						年级：<input type="text" name="UserGrade" id="UserTel"  value=<%=Useruser.getUserGrade() %> /><br/>
						班级：<input type="text" name="UserClass" id="UserClass" value=<%=Useruser.getUserClass() %> required />
						<input type="submit" name="" id="addStudentForm" value="提交" />
						<!-- 
							简介：<textarea rows="" cols="" value = <%=Useruser.getIntroduction() %> ></textarea>
							住址：<input type="text" name="UserAdr" id="UserAdr" value=<%=Useruser.getUserAdr() %> /><br/>
							电话：<input type="tel" name="UserTel" id="UserTel" value=<%=Useruser.getUserTel() %> /><br/>
							
						 -->
					</form>
				</div>

			</div>
		</div>
	</body>
</html>
