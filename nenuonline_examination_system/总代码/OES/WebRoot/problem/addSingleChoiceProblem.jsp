<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加单选题</title>
    
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
  </head>
  
  <body>
    <div class="oneAddContent">
	    <form id="oneAddForm" action="servlet/addSCProblemServlet" method="post">
	    	<span class="spanwide">题目内容:</span><input type="text" name="Content"><br>
	    	<span class="spanwide">选项A:</span><input type="text" name="OptionA"><br>
	    	<span class="spanwide">选项B:</span><input type="text" name="OptionB"><br>
	    	<span class="spanwide">选项C:</span><input type="text" name="OptionC"><br>
	    	<span class="spanwide">选项D:</span><input type="text" name="OptionD"><br>
	    	<span class="spanwide">正确答案:</span><input type="text" name="Answer"><br>
	    	<span class="spanwide">问题提交:</span><input type="submit" name="Submit" value="提交更改"><br>
	    </form>
    </div>
   	<div class="link">
    	<a href="servlet/showAllProblemServlet">返回题库列表</a>
    </div>
    
  </body>
</html>
