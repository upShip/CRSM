<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录失败</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    String msg = (String) session.getAttribute("message");
%>
</body>
<div align="center"> 
    <p></p><br/>
	<p></p><br/>
	<p>用户名或密码错误，3秒后将返回登录界面，请重新核对后再次登录</p><br/>
</div>

<%
    response.setHeader("Refresh", "3;URL=/CardSystem/Login.jsp");
%>
</html>
