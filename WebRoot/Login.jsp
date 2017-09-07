<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head> 
 	<meta charset="UTF-8"> 
 	<meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"> <meta http-equiv="X-UA-Compatible" content="ie=edge">
         <title>用户登录</title> 
 </head> 
 <body> 
 <%
     Object message = request.getAttribute("message");
     if(message!=null && !"".equals(message)){
 
  %>
      <script type="text/javascript">
          alert("<%=message%>");
      </script>
  <%} %>
 
 <form action="LoginServlet" name="frmLogin" method="post"> 
 	<h1 align="center">用户登录</h1> 
 	<div align="center"> 
 		<table border="1"> 
 			<tr> 
 				<td>用户名：</td> 
 				<td> 
 					<label> 
 						<input name="number" size="20" maxlength="20" type="text"/> 
 					</label> 
 				</td> 
 			</tr> 
 			<tr> 
 				<td>密 码：</td> 
 				<td> 
 					<label> 
 						<input type="password" name="password" size="20" maxlength="20" type="password" /> 
 					</label> 
 				</td> 
 			</tr> 
 			</table> 
 			<br/> 
 			<input type="submit" name="submit" value="登录" onclick="return validateLogin()"> 

 	</div> 
 </form> 
 
 <script type="text/javascript">
    function validateLogin() {
        var sUserName = document.frmLogin.username.value;
        var sPassWord = document.frmLogin.password.value;
        if(sUserName === "") {
            alert("请输入用户名！");
            return false;
        }

        if(sPassWord === "") {
            alert("请输入密码！");
            return false;
        }
    }
</script> 
</body> 
</html>
