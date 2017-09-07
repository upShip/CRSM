package com.fcfy.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fcfy.bean.User;
import com.fcfy.util.JDBCUtil;
import com.sun.jersey.api.core.HttpRequestContext;

public class ListServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//接收表单值
		String result="";
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		
//		response.sendRedirect("Login.jsp");
		
		//链接数据库
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		conn = JDBCUtil.getConnection();
		
//		try {
//			//获取预编译对象
//			ps = conn.prepareStatement("select * from user where name=? and password=?");
//			ps.setString(1, name);
//			ps.setString(2, password);
//			rs = ps.executeQuery();
//			
//			String message = "用户名或者 密码错误，请重新输入~";
//			
//			if(rs.next()){
//				//得到一个session
//				HttpSession session = request.getSession();
//				//将rs装进对想象中
//				User user = new User();
//				//传对象l
//				session.setAttribute("user", user);
//				
//				//日期
//				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//				String date = sim.format(new Date());
//				//传日期
//				session.setAttribute("date", date);
//				
//				//如果验证成功则跳转列表页面
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//			}else{
//				//否则。。。
//				request.setAttribute("message", message);
//				request.getRequestDispatcher("error.jsp").forward(request, response);
//			}
//			//关流
//			JDBCUtil.close(rs, ps, conn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
