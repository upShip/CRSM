package com.fcfy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到一个session
		HttpSession session = request.getSession();
		//销毁
		session.invalidate();
		//跳转页面
		response.sendRedirect("Login.jsp");
	}
}
