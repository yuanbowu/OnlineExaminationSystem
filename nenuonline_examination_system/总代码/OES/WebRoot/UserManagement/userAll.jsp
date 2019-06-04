<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import ="com.oes.entity.User"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="../css/pageAll.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../css/index.css"/>
		<link rel="stylesheet" type="text/css" href="../css/userManage.css"/>
	    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<title></title>
	</head>
	<%
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "管理员");
		map.put(2, "教务");
		map.put(3, "教师");
		map.put(4, "学生");
		List list = (List)session.getAttribute("list");
		
  		User Useruser = null;
  		User user = (User)session.getAttribute("user");
  		String sign = "";//用来隐藏一些信息
  		if( user.getUserPower()>1 ){
  			sign = "none";
  		}
  		
	 %>
	<body>
		
		<!-- 用户信息表格 -->
		<div class="search">
			<form action="../servlet/FindPersonServlet" method="post" >
			<input type="text" name="UserName"   id="" value="" placeholder="用户名"  />
			<input type="text" name="UserSchool" id="" style = "display:<%=sign %>" placeholder="学校" value="" />
			<input type="text" name="UserPower" id="" style = "display:<%=sign %>" placeholder="分类" value="" />
			<input type="submit" name="" id="pageAllSUmbit" value=""/>
			</form>
							<!--<button type="button"></button>  -->
		</div>
		<table border="" cellspacing="" cellpadding="">
			
			<%
			if( list!=null ){
			%>
			<tr style="position: sticky; top: 0px; background-color: white;">
				<th>身份</th>
				<th>ID</th>
				<th>姓名</th>
				<th>学校</th>
				<th>学院</th>
				<th>操作</th>
			</tr>
			<%
			
				int i;
				for(i=0;i<list.size();i++){
				Useruser = (User)list.get(i);
			 %>
			<tr>
				<td><%=map.get(Useruser.getUserPower()) %></td>
				<td>203679230</td>
				<td><%=Useruser.getUserName() %></td>
				<td><%=Useruser.getUserSchool() %></td>
				<td><%=Useruser.getUserGrade() %></td>
				<td>
				<button type="button" class="buttonClick" onclick="parent.location.href='../servlet/findbyUid?Uid=<%=Useruser.getUid() %>'" >查看详情</button>
				</td>
				
			</tr>
			<%
				}
			}
			 %>
			
				
		</table>
		<!-- <ul  class="pagination pagination-lg">
			<li class="page-item"><a class="page-link" href="#">前一页</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">后一页</a></li>
		</ul> -->
	</body>
</html>
