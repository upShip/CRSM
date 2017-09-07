<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'GeneralIndustry.jsp' starting page</title>

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
	<%  
  String userName = (String)session.getAttribute("userName");  
  System.out.println(userName);
 %>
    		<!-- <form action="ListServlet" name="frmList" method="post">  --> 
    		
    <form action="GeneralIndustryServlet" name="frmSubmit" method="post"> 
              <table align = "center" border="1" style="border-collapse: collapse; width: 70%">
                  <tr>
                      <!-- <td colspan="2" align="center">当前用户：<%=userName %></td> -->
                      <td colspan="20" align="center" style="height: 40px;">通用行业经营情况</td>
                  </tr>
                  
                  <tr>
                      <td colspan="2">机构名称 <input name="agencyName" size="20" maxlength="20" type="text"/></td> 
                  </tr>
                  <tr>
                      <td colspan="2">企业名称<input name="companyName" size="20" maxlength="20" type="text"/></td> 
                  </tr>
                  <tr>
                      <td colspan="2">法定代表人<input name="corporation" size="20" maxlength="20" type="text"/></td> 
                  </tr>
                  
                  <tr>
					<td colspan="2" align="left" style="height: 30px;">企业或实际控制人与我行建立授信业务时间
                  		<select name="creditTime">
                  			<option value="100">请输入企业或实际控制人与我行建立授信业务时间 </option>  
                  			<option value="3">与我行建立授信业务满2年或以上</option>
							<option value="2">与我行建立授信业务在1年(含)至2年</option>
							<option value="1">与我行建立授信业务不满1年或首次向我行申请授信</option>
                  		</select>
                  	</td>
                  </tr>

			<tr>
				<td rowspan="4" align="center" style="width: 20%;">授信方案设计(固定资产贷款不评估该指标)</td>
			</tr>
			<tr>
				<td align="left">客户在我行授信金额是否占其全部授信银行授信金额50%(含)以上 <input
					name="creditScheme1" value="1" type="checkbox" />
				</td>
			</tr>

			<tr>
				<td align="left">客户在我行结算量是否占其全部开户银行结算量50%(含)以上 <input
					name="creditScheme2" value="1" type="checkbox" />
				</td>
			</tr>

			<tr>
				<td align="left">该客户及其法定代表人或实际控制人是否将主要资产抵押在我行 <input
					name="creditScheme3" value="1" type="checkbox" />
				</td>
			</tr>

			<tr>
				<td rowspan="3" align="center" style="width: 20%;">存贷比</td>
			</tr>
			<tr>
				<td align="left">日均存款<input
					name="dailyDeposit" type="text" onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')"/>
				</td>
			</tr>

			<tr>
				<td align="left">授信敞口 <input
					name="creditExposure" type="text" onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')"/>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="left" style="height: 30px;">年龄 <input
					name="age" onkeyup="keyPress">
				</td>
			</tr>

			<tr>
				<td colspan="2" align="left" style="height: 30px;">从事本行业时间 <select
					name="employmentTime">
						<option value="100">请输入从事本行时间 </option>
						<option value="3">5年(含)以上</option>
						<option value="2">3年(含)至5年</option>
						<option value="1">1年(含)至3年</option>
						<option value="0">1年以下</option>
				</select>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="left" style="height: 30px;">征信系统信用记录 <select
					name="creditRecord">
						<option value="100">请选择信用记录 </option>
						<option value="3">近6个月按时还本付息</option>
						<option value="2">近6个月无信用记录</option>
						<option value="1">近6个月有1期未按时归还本息</option>
						<option value="0">近6个月有2期(含)以上未按时归还本息</option>
				</select>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="left" style="height: 30px;">对外投资情况 <select
					name="outInvestmentSituation">
						<option value="100">请选择对外投资情况 </option>
						<option value="1|无对外投资">无对外投资</option>
						<option value="2">对外投资项目与本次申请授信的小企业经营紧密相关</option>
						<option value="0">对外投资项目超过2个且与本次申请授信的小企业经营不相关</option>
						<option value="1">对外投资项目不超过2个且与本次申请授信的小企业经营基本不相关</option>
				</select>
				</td>
			</tr>

			<tr>
				<td rowspan="7" align="center" style="width: 20%;">家庭净资产（元）</td>
			</tr>
			
			<tr>
				<td align="left">房产 <input name="fangchan" type="text"
					onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')" />
				</td>
			</tr>
			<tr>
				<td align="left">股权 <input name="guquan" type="text"
					onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')" />
				</td>
			</tr>
			<tr>
				<td align="left">汽车 <input name="qiche" type="text"
					onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')" />
				</td>
			</tr>
			<tr>
				<td align="left">有价证券 <input name="zhengquan" type="text"
					onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')" />
				</td>
			</tr>
			<tr>
				<td align="left">其他资产 <input name="zichan" type="text"
					onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')" />
				</td>
			</tr>
			<tr>
				<td align="left">对应的贷款金额 <input name="daikuan" type="text"
					onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="left" style="height: 30px;">企业产权制度 <select
					name="enterpriseProperty">
						<option value="100">请选择企业产权制度 </option>
						<option value="2|股份有限公司">股份有限公司</option>
						<option value="2|有限责任公司">有限责任公司</option>
						<option value="2|全民所有制企业">全民所有制企业</option>
						<option value="1">集体所有制企业</option>
						<option value="0.5|个体工商户">个体工商户</option>
						<option value="0.5|个人合伙企业">个人合伙企业</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="left" style="height: 30px;">生产或经营场所 <select
					name="productionPlace">
						<option value="100">请选择生产场所 </option>
						<option value="5">自有产权（含实际控制人自有产权）</option>
						<option value="4">租赁且租赁期限在2年以上</option>
						<option value="2">租赁且租赁期限在2年(含)以内的</option>
						<option value="0">借用经营场所</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td rowspan="3" align="center" style="width: 20%;">经营许可资质</td>
			</tr>
			<tr>
				<td align="left">有无相关经营资质 <input
					name="haveQualifications" value="2" type="checkbox" />
				</td>
			</tr>

			<tr>
				<td align="left">是否在资质有效期内 <input
					name="isValidity" value="1" type="checkbox" />
				</td>
			</tr>
			
			
			
			
			
			
			<tr>
				<td colspan="2" align="left" style="height: 30px;">纳税情况 <select
					name="taxSituation">
						<option value="100">请选择纳税情况 </option>
						<option value="2">企业近两年正常纳税</option>
						<option value="1">企业目前正常纳税</option>
						<option value="0">企业无纳税</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="left" style="height: 30px;">商品销售网络或渠道 <select
					name="goodsSale">
						<option value="100">请选择商品销售网络或渠道</option>
						<option value="3">客户众多且与大型客户或大型卖场建立合作关系</option>
						<option value="2">与大型客户或大型卖场建立合作关系</option>
						<option value="1">拥有较多客户</option>
						<option value="0">客户数量有限且未与大型客户或大型卖场建立合作关系</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="left" style="height: 30px;">企业成立时间 <select
					name="enterpriseFoungingTime">
						<option value="100">请选择企业成立时间</option>
						<option value="4">5年及5年以上</option>
						<option value="3">3年(含)至5年</option>
						<option value="2">1年(含)至3年</option>
						<option value="0">1年以下</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td rowspan="4" align="center" style="width: 20%;">行业门槛</td>
			</tr>
			<tr>
				<td align="left">自有资金投资比例要求 <input
					name="threshold" value="0.5" type="checkbox" />
				</td>
			</tr>

			<tr>
				<td align="left">特定审批要求 <input
					name="threshold" value="1" type="checkbox" />
				</td>
			</tr>

			<tr>
				<td align="left">主要商品供应商保证金或代理销售额要求 <input
					name="threshold" value="1" type="checkbox" />
				</td>
			</tr>
			
			
			
			
			
			
			
			
			
			
			
			
			

			<tr>
				<td colspan="2" align="center"><input type="submit" id="submit"
					value="提交"></td>
			</tr>

		</table>
     </form>
    
 <script type="text/javascript">
 onclick="return validateSubmit()"
    function validateSubmit() {
    	var age = document.frmSubmit.age.value;    
    	alert(age);
    }
</script>     
    
  </body>
</html>
