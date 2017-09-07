package com.fcfy.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.kerberos.KerberosKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

import com.fcfy.bean.User;
import com.fcfy.util.JDBCUtil;

public class GeneralIndustryServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//���ձ�ֵ
		
		String idString = (String) request.getAttribute("agencyName");
		System.out.println("----------------"+idString);
		//��������
		String agencyName = request.getParameter("agencyName");
		//��ҵ����
		String companyName = request.getParameter("companyName");
		//����������
		String corporation = request.getParameter("corporation");
		
		System.out.println("��������"+agencyName + "��ҵ����" + companyName + "����������" + corporation);
		
		//��ҵ��ʵ�ʿ����������н�������ҵ��ʱ��
		String creditTime = request.getParameter("creditTime");
		System.out.println("��ҵ��ʵ�ʿ����������н�������ҵ��ʱ��"+creditTime);
		
		
		
		
		//���ŷ������(�̶��ʲ����������ָ��)
		String creditScheme1 = request.getParameter("creditScheme1");
		String creditScheme2 = request.getParameter("creditScheme2");
		String creditScheme3 = request.getParameter("creditScheme3");
		
		System.out.println(creditScheme1+"===="+creditScheme2+"===="+creditScheme3);
		
		
//		String[] creditScheme = request.getParameterValues("creditScheme");  
//		int creditSchemeNum = creditScheme.length;//�����ݿ��в��������
//        String delStr = "";  
//        for(int i=0;i<creditScheme.length;i++)  {
//            delStr+=creditScheme[i]+",";  
//        }
//        delStr=delStr.substring(0,delStr.length()-1); 
//        System.out.println("���ŷ������"+delStr); 
//        System.out.println("���ŷ�������"+creditSchemeNum);

        /*�����  a�վ����    b���ų���     k=a/b  
         k>=0.1   4
         0<k<0.1  4*(k/0.1)
        */
        double loanDepositRatio = 0;
        double lpr;
      
        //a�վ����
        double dailyDeposit = Double.parseDouble(request.getParameter("dailyDeposit"));
        //b���ų���
        double creditExposure = Double.parseDouble(request.getParameter("creditExposure"));
        lpr=dailyDeposit/creditExposure;
        
        if (lpr>=0.1) {
			loanDepositRatio = 4;
		}else if (lpr>0 && lpr<0.1) {
			loanDepositRatio = 4*(lpr/0.1);
		}
        
        System.out.println("�����"+lpr);
        String st = Double.toString(loanDepositRatio);
        System.out.println("����ȷ�ֵ"+st);

		//����
		String ageString=request.getParameter("age");
		
		String ageValue = null;
		int age = Integer.parseInt(ageString);
		
		if (age>30 && age<48) {
			ageValue = "1";
		}else if ((age >22 && age < 30)|| (age > 48 && age < 58)) {
			ageValue = "0.5";
		}else if (age <= 22 || age >= 58) {
			ageValue = "2";
		}
		
		System.out.println("����"+ageValue);
		
		//���±���ҵʱ��
		String employmentTime = request.getParameter("employmentTime");
		System.out.println("���±���ҵʱ��"+employmentTime);
		
		//����ϵͳ���ü�¼
		String creditRecord = request.getParameter("creditRecord");
		System.out.println("����ϵͳ���ü�¼"+creditRecord);
		//����Ͷ�����
		String outInvestmentSituation = request.getParameter("outInvestmentSituation");
		System.out.println("����Ͷ�����"+outInvestmentSituation);
		
		//��ͥ���ʲ� K=(a+b+c+d+e)-f ��kΪ������ô��ָ���0��
		/*
		 K��4000000��Ԫ����ͬ��		6
		 3000000��K<4000000		4
		 2000000��K<3000000		3
		 1000000��K<2000000		2
		 500000��K<1000000		1
		 K<500000				0
		 */
		String familyNetAssets = null;

		double k;
		//a���� 
		double a = Double.parseDouble(request.getParameter("fangchan"));
		//b��Ȩ  
		double b = Double.parseDouble(request.getParameter("guquan"));
		//c���� 
		double c = Double.parseDouble(request.getParameter("qiche"));
		//d�м�֤ȯ 
		double d = Double.parseDouble(request.getParameter("zhengquan"));
		//e�����ʲ� 
		double e = Double.parseDouble(request.getParameter("zichan"));
		//f��Ӧ�Ĵ�����
		double f = Double.parseDouble(request.getParameter("daikuan"));
		
		k=(a+b+c+d+e)-f;
		
		System.out.println(a+"===="+b+"===="+c+"===="+d+"===="+e+"===="+f+"===="+k);

		if (k<0) {
			familyNetAssets = "0";
		}else if (k>=4000000) {
			familyNetAssets = "6";
		}else if (k>=3000000 && k<=4000000) {
			familyNetAssets = "4";
		}else if (k>=2000000 && k<3000000) {
			familyNetAssets = "3";
		}else if (k>=1000000 && k<2000000) {
			familyNetAssets = "2";
		}else if (k>=500000 && k<1000000) {
			familyNetAssets = "1";
		}else if (k<500000){
			familyNetAssets = "0";
		}

		System.out.println("��ͥ���ʲ�"+familyNetAssets);
		
		
		//��ҵ��Ȩ�ƶ� enterpriseProperty
		String enterpriseProperty = request.getParameter("enterpriseProperty");
		System.out.println("��ҵ��Ȩ�ƶ�"+enterpriseProperty);
		
		//������Ӫ����
		String productionPlace = request.getParameter("productionPlace");
		System.out.println("������Ӫ����"+productionPlace);
		
		//��Ӫ�������
		
		
		//��˰���
		String taxSituation = request.getParameter("taxSituation");
		System.out.println("��˰���"+taxSituation);
		
		//��Ʒ�������������
		String goodsSale = request.getParameter("goodsSale");
		System.out.println("��Ʒ�������������"+goodsSale);
		
		//��ҵ����ʱ��
		String enterpriseFoungingTime = request.getParameter("enterpriseFoungingTime");
		System.out.println("��ҵ����ʱ��"+enterpriseFoungingTime);
		
		//��ҵ�ż�
		/*�����ʽ�Ͷ�ʱ���Ҫ��      			ѡ���С���0.5�֣�ѡ���ޡ���0��
		 *�ض�����Ҫ��		   		            ѡ���С���1�֣�ѡ���ޡ���0��
		 *��Ҫ��Ʒ��Ӧ�̱�֤���������۶�Ҫ��	ѡ���С���1�֣�ѡ���ޡ���0��
		*/
		String[] threshold = request.getParameterValues("threshold");  
		int thresholdNum = threshold.length;
		String thresholdStr = "";
		
//		double x = Double.parseDouble(threshold[0]);
//		double y = Double.parseDouble(threshold[1]);
//		double z = Double.parseDouble(threshold[2]);
//		double w = x+y+z;
//		
//		if (w>1) {
//			thresholdStr = "1";
//		}else {
//			thresholdStr = "0";
//		}
		
		if (thresholdNum >= 2) {
			thresholdStr = "1";
		}else {
			thresholdStr = "0.5";
		}
		
		System.out.println("��ҵ�ż�"+thresholdStr);
		
//        String threshotr = "";
//        for(int i=0;i<creditScheme.length;i++)  {
//        	thresholdStr+=creditScheme[i]+",";  
//        }
//        thresholdStr=thresholdStr.substring(0,thresholdStr.length()-1);  
		
		
		
		
		
		
		
		
		
		
		//�������ݿ�
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		conn = JDBCUtil.getConnection();
//		
//		try {
//			//��ȡԤ�������
//			ps = conn.prepareStatement("select * from user where number=? and password=?");
//			ps.setString(1, number);
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
//				user.setName(rs.getString(3));
//				//������
//				session.setAttribute("userName", user.getName());
//				
//				System.out.println("��¼�ɹ���������תList.jsp");
//				
//				//�����֤�ɹ�����ת�б�ҳ��
//				request.getRequestDispatcher("List.jsp").forward(request, response);
//			}else{
//				//���򡣡���				
//				request.setAttribute("message", message);
//				request.getRequestDispatcher("Login.jsp").forward(request, response);
//			}
//			//����
//			JDBCUtil.close(rs, ps, conn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
}


}
