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
		//���ձ�ֵ
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		
//		System.out.println(number);
//		System.out.println(password);
		
		//�������ݿ�
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn = JDBCUtil.getConnection();
		
		try {
			//��ȡԤ�������
			ps = conn.prepareStatement("select * from user where number=? and password=?");
			ps.setString(1, number);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			String message = "�û������� �����������������~";
			
			if(rs.next()){
				//�õ�һ��session
				HttpSession session = request.getSession();
				//��rsװ����������
				User user = new User();
				user.setName(rs.getString(3));
				//������
				session.setAttribute("userName", user.getName());
				
				System.out.println("��¼�ɹ���������תList.jsp");
				
				//�����֤�ɹ�����ת�б�ҳ��
				request.getRequestDispatcher("List.jsp").forward(request, response);
			}else{
				//���򡣡���				
				request.setAttribute("message", message);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			//����
			JDBCUtil.close(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
