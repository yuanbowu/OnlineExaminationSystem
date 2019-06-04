<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自定义考试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/addQuestion.css"/>
	<link rel="stylesheet" type="text/css" href="css/testQuestionManage.css"/>
	<link rel="stylesheet" type="text/css" href="css/link.css"/>
	<script type="text/javascript">
		var cnt = 1;
	  	function addProblem(){
	  		++cnt;
	    	var cont = document.getElementById("examForm").innerHTML;
	  		document.getElementById("examForm").innerHTML = cont + "题目" + cnt + "ID：<input type=\"text\" name=\"Problem" + cnt + "\"><br>";
	  	}
	</script>
	
  	</head>
  
  <body>
  	<% 
  		String error = (String)request.getAttribute("error");
  		if(error != null) out.print(error + "<br>");
  	%>
 
    <div class="oneAddContent">
	    <form action="servlet/addEOTServlet" method="post" id="examForm">
	    	<button type="button" onclick="addProblem()"> 添加试题 </button>
	    	<input type="submit" value="提交"><br>
	    	<span class="spanwide">考试名称:</span><input type="text" name="Name"><br>
	    	<span class="spanwide">密码:</span><input type="text" name="Password"><br>
	    	<span class="spanwide">时间格式:</span>		2019-05-15 15:55:00<br>
	    	<span class="spanwide">开始时间:</span><input type="text" name="StartTime"><br>
	    	<span class="spanwide">结束时间:</span><input type="text" name="EndTime"><br>
	    	<span class="spanwide">题目1ID:</span><input type="text" name="Problem1"><br>
	    </form>
    </div>
    <div class="link">
    	<a href="servlet/showAllExamServlet">返回考试列表</a>
    </div>
    
  </body>
</html>
