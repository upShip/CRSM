/*创建经营人情况表*/

/*1.年龄
  2.从事本行业时间
  3.征信系统信用记录
  4.对外投资情况
  5.家庭净资产
*/
create table transactor(
customerNum varchar(8) primary key,
customerName varchar(10),
corporation varchar(10);
age varchar(6),
employmentTime varchar(6),
creditRecord varchar(6),
outInvestmentSituation varchar(6),
familyNetAssets varchar(6)
);

