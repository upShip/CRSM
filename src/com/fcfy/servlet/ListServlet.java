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
		//���ձ�ֵ
		String result="";
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		
//		response.sendRedirect("Login.jsp");
		
		//�������ݿ�
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		conn = JDBCUtil.getConnection();
		
//		try {
//			//��ȡԤ�������
//			ps = conn.prepareStatement("select * from user where name=? and password=?");
//			ps.setString(1, name);
//			ps.setString(2, password);
//			rs = ps.executeQuery();
//			
//			String message = "�û������� �����������������~";
//			
//			if(rs.next()){
//				//�õ�һ��session
//				HttpSession session = request.getSession();
//				//��rsװ����������
//				User user = new User();
//				//������l
//				session.setAttribute("user", user);
//				
//				//����
//				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//				String date = sim.format(new Date());
//				//������
//				session.setAttribute("date", date);
//				
//				//�����֤�ɹ�����ת�б�ҳ��
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//			}else{
//				//���򡣡���
//				request.setAttribute("message", message);
//				request.getRequestDispatcher("error.jsp").forward(request, response);
//			}
//			//����
//			JDBCUtil.close(rs, ps, conn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
