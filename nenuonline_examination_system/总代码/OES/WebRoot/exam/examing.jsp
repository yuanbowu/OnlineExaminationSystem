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
    <%
		ExamWithoutTest EOT = (ExamWithoutTest)request.getSession().getAttribute("EOT");
		if(EOT == null) request.getRequestDispatcher("index.jsp");
	 %>
    <title>
    <% 
    	out.print(EOT.getName());
    %>
    </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/page.css"/>
	<link rel="stylesheet" type="text/css" href="css/link.css"/>
	<script type="text/javascript">
	    function dayBetween(){
	        var now = new Date().getTime();
	        var end = new Date("<%=EOT.getEndTime()%>");
	        var between = end - now;
	        // console.log("between:" + between);
	        if(between <= 0){
	        	document.getElementById('myAnswer').submit();
	        }
	        var sec = Math.floor(between/1000);
	        var day = Math.floor((Math.floor((Math.floor(sec/60))/60))/24); 
	        var hours = (Math.floor((Math.floor(sec/60))/60))%24;
	        var minutes = (Math.floor(sec/60))%60 ;
	        var seconds =  sec%60;
	        // console.log("result:" + day + "天" + hours + "时" + minutes + "分" + seconds + "秒");
	       	var t = document.getElementById("time");
	       	t.innerHTML = "考试结束还剩：" + "<b>" + day + "天" + hours + "时" + minutes + "分" + seconds + "秒" + "</b>";
	    }
	    window.onload = function(){
	    	dayBetween();
	      	setInterval(dayBetween, 1000);
	    };
	</script>
	
	
  </head>
  <body>
  		<!-- 在线考试的试卷 -->
	    	

		<div class="pageInformation">
			<% 
	    		out.print("<h1>" + EOT.getName() + "</h1><br/>");
	    	%>
	    	<% 
	    		out.print("举办人id： <span id=\"autor\">" + EOT.getOwner() + "</span>");
	    	%>

	    	<% 
	    		out.print("开始时间： <span id=\"testTime\">" + EOT.getStartTime() + "</span>");
	    	%>

	    	<% 
	    		out.print("结束时间： <span id=\"testTime\">" + EOT.getEndTime() + "</span>");
	    	%>
	    	
		</div>
		<div class="timeCount">
			<span>离考试结束还有： </span> <span id="time"></span>
		</div>
		<div class="examContent">
			<form action="servlet/answerServlet" method="post" id="pageForm">
	    		<% 
		    		out.print("<input type=\"hidden\" name=\"Eid" + "\"value=\"" + EOT.getEid() + "\">");
		    	%>
				<%
					List<SingleChoiceProblem> SCPList = (List<SingleChoiceProblem>)request.getSession().getAttribute("SCPList");
					int sz = SCPList.size();
					for(int i = 0; i < sz; ++i){
						SingleChoiceProblem SCP = SCPList.get(i);
						out.print("<p class=\"questionTitle\"><h3>题目" + (i + 1) + "</h3>");
						out.print(SCP.getContent() + "</p>");
						out.print("<div class=\"answer\">选项A： " + SCP.getOptionA() + "</div>");
						out.print("<div class=\"answer\">选项B： " + SCP.getOptionB() + "</div>");
						out.print("<div class=\"answer\">选项C： " + SCP.getOptionC() + "</div>");
						out.print("<div class=\"answer\">选项D： " + SCP.getOptionD() + "</div>");
						out.print("你的选择是： " + "<input type=\"text\" name=\"Choice" + (i + 1) + "\">" + "<br />");
						out.print("<input type=\"hidden\" name=\"Answer" + (i + 1) + "\"value=\"" + SCP.getAnswer() + "\"><br />");
						out.print("<input type=\"hidden\" name=\"sPid" + (i + 1) + "\"value=\"" + SCP.getsPid() + "\"><br />");
					}
				 %>
				<div class="contentSubmission">
					<input type="submit" value="提交答卷">
				</div>
	    	</form>

		</div>
  </body>
</html>






