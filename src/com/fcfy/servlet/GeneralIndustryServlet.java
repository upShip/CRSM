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
		//接收表单值
		
		String idString = (String) request.getAttribute("agencyName");
		System.out.println("----------------"+idString);
		//机构名称
		String agencyName = request.getParameter("agencyName");
		//企业名称
		String companyName = request.getParameter("companyName");
		//法定代表人
		String corporation = request.getParameter("corporation");
		
		System.out.println("机构名称"+agencyName + "企业名称" + companyName + "法定代表人" + corporation);
		
		//企业或实际控制人与我行建立授信业务时间
		String creditTime = request.getParameter("creditTime");
		System.out.println("企业或实际控制人与我行建立授信业务时间"+creditTime);
		
		
		
		
		//授信方案设计(固定资产贷款不评估该指标)
		String creditScheme1 = request.getParameter("creditScheme1");
		String creditScheme2 = request.getParameter("creditScheme2");
		String creditScheme3 = request.getParameter("creditScheme3");
		
		System.out.println(creditScheme1+"===="+creditScheme2+"===="+creditScheme3);
		
		
//		String[] creditScheme = request.getParameterValues("creditScheme");  
//		int creditSchemeNum = creditScheme.length;//往数据库中插入的数据
//        String delStr = "";  
//        for(int i=0;i<creditScheme.length;i++)  {
//            delStr+=creditScheme[i]+",";  
//        }
//        delStr=delStr.substring(0,delStr.length()-1); 
//        System.out.println("授信方案设计"+delStr); 
//        System.out.println("授信方案分数"+creditSchemeNum);

        /*存贷比  a日均存款    b授信敞口     k=a/b  
         k>=0.1   4
         0<k<0.1  4*(k/0.1)
        */
        double loanDepositRatio = 0;
        double lpr;
      
        //a日均存款
        double dailyDeposit = Double.parseDouble(request.getParameter("dailyDeposit"));
        //b授信敞口
        double creditExposure = Double.parseDouble(request.getParameter("creditExposure"));
        lpr=dailyDeposit/creditExposure;
        
        if (lpr>=0.1) {
			loanDepositRatio = 4;
		}else if (lpr>0 && lpr<0.1) {
			loanDepositRatio = 4*(lpr/0.1);
		}
        
        System.out.println("存贷比"+lpr);
        String st = Double.toString(loanDepositRatio);
        System.out.println("存贷比分值"+st);

		//年龄
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
		
		System.out.println("年龄"+ageValue);
		
		//从事本行业时间
		String employmentTime = request.getParameter("employmentTime");
		System.out.println("从事本行业时间"+employmentTime);
		
		//征信系统信用记录
		String creditRecord = request.getParameter("creditRecord");
		System.out.println("征信系统信用记录"+creditRecord);
		//对外投资情况
		String outInvestmentSituation = request.getParameter("outInvestmentSituation");
		System.out.println("对外投资情况"+outInvestmentSituation);
		
		//家庭净资产 K=(a+b+c+d+e)-f 如k为负数则该打分指标得0分
		/*
		 K≥4000000（元，下同）		6
		 3000000≤K<4000000		4
		 2000000≤K<3000000		3
		 1000000≤K<2000000		2
		 500000≤K<1000000		1
		 K<500000				0
		 */
		String familyNetAssets = null;

		double k;
		//a房产 
		double a = Double.parseDouble(request.getParameter("fangchan"));
		//b股权  
		double b = Double.parseDouble(request.getParameter("guquan"));
		//c汽车 
		double c = Double.parseDouble(request.getParameter("qiche"));
		//d有价证券 
		double d = Double.parseDouble(request.getParameter("zhengquan"));
		//e其他资产 
		double e = Double.parseDouble(request.getParameter("zichan"));
		//f对应的贷款金额
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

		System.out.println("家庭净资产"+familyNetAssets);
		
		
		//企业产权制度 enterpriseProperty
		String enterpriseProperty = request.getParameter("enterpriseProperty");
		System.out.println("企业产权制度"+enterpriseProperty);
		
		//生产或经营场所
		String productionPlace = request.getParameter("productionPlace");
		System.out.println("生产或经营场所"+productionPlace);
		
		//经营许可资质
		
		
		//纳税情况
		String taxSituation = request.getParameter("taxSituation");
		System.out.println("纳税情况"+taxSituation);
		
		//商品销售网络或渠道
		String goodsSale = request.getParameter("goodsSale");
		System.out.println("商品销售网络或渠道"+goodsSale);
		
		//企业成立时间
		String enterpriseFoungingTime = request.getParameter("enterpriseFoungingTime");
		System.out.println("企业成立时间"+enterpriseFoungingTime);
		
		//行业门槛
		/*自有资金投资比例要求      			选择“有”得0.5分，选择“无”得0分
		 *特定审批要求		   		            选择“有”得1分，选择“无”得0分
		 *主要商品供应商保证金或代理销售额要求	选择“有”得1分，选择“无”得0分
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
		
		System.out.println("行业门槛"+thresholdStr);
		
//        String threshotr = "";
//        for(int i=0;i<creditScheme.length;i++)  {
//        	thresholdStr+=creditScheme[i]+",";  
//        }
//        thresholdStr=thresholdStr.substring(0,thresholdStr.length()-1);  
		
		
		
		
		
		
		
		
		
		
		//链接数据库
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		conn = JDBCUtil.getConnection();
//		
//		try {
//			//获取预编译对象
//			ps = conn.prepareStatement("select * from user where number=? and password=?");
//			ps.setString(1, number);
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
//				user.setName(rs.getString(3));
//				//传对象
//				session.setAttribute("userName", user.getName());
//				
//				System.out.println("登录成功，即将跳转List.jsp");
//				
//				//如果验证成功则跳转列表页面
//				request.getRequestDispatcher("List.jsp").forward(request, response);
//			}else{
//				//否则。。。				
//				request.setAttribute("message", message);
//				request.getRequestDispatcher("Login.jsp").forward(request, response);
//			}
//			//关流
//			JDBCUtil.close(rs, ps, conn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
}


}
