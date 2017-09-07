<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>Personal Password</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
  
  </head>  
    
  <body>  
    <br>  
    <form action ="<c:url value='/UserServlet?act=changepwd' />" method="post">  
        <span>请输入原密码:</span>     
        <input type = "password"  name ="oldpwd" >  
        <br/>  
        <span>请输入新密码:</span>     
        <input type = "password"  name ="newpwd" >  
        <br/>  
        <span>请再次输入新密码:</span>  
        <input type = "password"  name ="confirm" > 
        <br/>
        <input type = "submit" value = "提交修改" >  
        </form>  
  </body>  
</html>  