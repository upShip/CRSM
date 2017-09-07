package com.fcfy.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

import com.fcfy.bean.User;
import com.fcfy.util.JDBCUtil;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//接收表单值
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		
//		System.out.println(number);
//		System.out.println(password);
		
		//链接数据库
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn = JDBCUtil.getConnection();
		
		try {
			//获取预编译对象
			ps = conn.prepareStatement("select * from user where number=? and password=?");
			ps.setString(1, number);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			String message = "用户名或者 密码错误，请重新输入~";
			
			if(rs.next()){
				//得到一个session
				HttpSession session = request.getSession();
				//将rs装进对想象中
				User user = new User();
				user.setName(rs.getString(3));
				//传对象
				session.setAttribute("userName", user.getName());
				
				System.out.println("登录成功，即将跳转List.jsp");
				
				//如果验证成功则跳转列表页面
				request.getRequestDispatcher("List.jsp").forward(request, response);
			}else{
				//否则。。。				
				request.setAttribute("message", message);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			//关流
			JDBCUtil.close(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
