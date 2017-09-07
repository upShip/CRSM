<%@page import="com.sun.xml.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="com.fcfy.bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta charset="UTF-8">
    <base href="<%=basePath%>">
    
    <title>My JSP 'List.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		.logout {
		float:right;
		width: 60px;
		height: 30px;}
		
		.button {
		width:100px;
		widding:60px;
		}
		.href {
		 text-decoration: none;
		}
	</style>

  </head>
  
  <body>
  <%  
  String userName = (String)session.getAttribute("userName");  
  System.out.println(userName);
  %>
    		<!-- <form action="ListServlet" name="frmList" method="post">  --> 
    		<form method="post"> 
              <table align = "center" border="1" style="border-collapse: collapse; width:60%">
                  <tr>
                      <td colspan="2" align="center">当前用户：<%=userName %>
                      <a href="LogoutServlet"><button type="button" name="button" class="logout">注销</button>
                      </td>
                  </tr>
                  <tr>
                  	<td align="center" style="height: 40px; width: 50%">对公</td>
           			<td align="center" style="height: 40px; width: 50%">对私</td>
                  </tr>
                 <tr>
                     <td style="vertical-align:middle; text-align:center;">
                         <a href="Commerce.jsp" class="href">商贸业经营情况</a><br>
                         <a href="Manufacturing.jsp" class="href">制造业经营情况</a><br>
                         <a href="GeneralIndustry.jsp" class="href">通用行业经营情况</a>
                     </td>
                     <td>
                         <input type="checkbox" name="question" value="篮球" />   </br>
                         <input type="checkbox" name="question" value="足球" />   </br>
                         <input type="checkbox" name="question" value="羽毛球" />  </br>
                         <input type="checkbox" name="question" value="跑步" />  </br>
                     </td>
                     
                    <tr >
                  		<td colspan="2" align="center"">
                  			<input type="submit" name="submit" value="确定" class="button">
                  			<input type="submit" name="submit" value="修改" class="button">
                  		</td>
           			
                    </tr>
                     
                 </tr>
               
             </table>
     </form>
  </body>
</html>
