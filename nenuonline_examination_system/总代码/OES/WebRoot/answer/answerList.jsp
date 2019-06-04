<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import ="com.oes.entity.User"  %>
<%@ page import ="com.oes.entity.Answer"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的答卷列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/pageAll.css"/>
	<link rel="stylesheet" type="text/css" href="css/link.css"/>
  </head>
  <%
	User user = (User) session.getAttribute("user");
	ArrayList<Answer> aList = (ArrayList<Answer>)request.getAttribute("AnswerList");
	String error = (String)request.getAttribute("error");
  %>
  <body>
  	<%
  		if(error != null) out.print(error + "<br />");
  	 %>
  	 
   	 您好，<%=user.getUserName()%>, 你提交的答卷有<br />
   	  
   	  <table border="" cellspacing="" cellpadding="">
			<tr style="position: sticky; top: 0px; background-color: white;">
				<th>考试序号</th>
				<th>考卷id</th>
				<th>用户id</th>
				<th>考试id</th>
				<th>考卷得分</th>
				<th>查看详情</th>
				
			</tr>
			<%
				int sz = aList.size();
		   	 	for(int i = 0; i < sz; ++i){
		   	 		Answer ans = aList.get(i);
		   	 		out.println("<tr>");
		    		out.println("<td> 考试" + (i + 1) + "</td>");
		    		out.println("<td> 考卷id: " + ans.getAid() + "</td>");
		    		out.println("<td> 用户id: " + ans.getOwner() + "</td>");
		    		out.println("<td> 考试id: " + ans.getExam()  + "</td>");
		    		out.println("<td> 考卷得分： " + ans.getScore() + "</td>");
		    		out.println("<td><form action=\"servlet/showThisAnswerServlet\" method=\"post\"><input type=\"hidden\" value=\"" + ans.getExam() + "\" name=\"Eid\">");
		    		out.println("<input type=\"submit\" value=\"查看详情\">");
		    		out.println("</form></td>");
		    		out.println("</tr>");

		   	 	}
			 %>
		</table>
   	  
  </body>
  
  		
  		
</html>
