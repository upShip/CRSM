/*财务情况 financial*/
/*
1.规模指标		scaleIndex
2.偿债能力		sovency
3.经营能力		capaxNegotii
4.经营效益		managementBenefit
*/
create table financial(
customerNum varchar(8) primary key,
scaleIndex varchar(6),
sovency varchar(6),
capaxNegotii varchar(6),
managementBenefit varchar(6)
);


/*授信情况 creditSituation*/
/*  
1.企业或实际控制人与我行建立授信业务时间	creditTime
2.授信方案设计（固定资产贷款不评估该指标）	creditScheme
3.存贷比						loanDepositRatio
*/
create table credit(
customerNum varchar(8) primary key,
creditTime varchar(6),
creditScheme varchar(10),
loanDepositRatio varchar(10)
);


/*通用行业经营情况 generalIndustry
  1.企业产权制度		enterpriseProperty
  2.生产或经营场所		productionPlace
  3.经营许可资质		managementAptitude
  4.纳税情况			taxSituation
  5.商品销售网络或渠道	goodsSale
  6.企业成立时间		enterpriseFoungingTime
  7.行业门槛			threshold
*/
create table generalIndustry(
customerNum varchar(8) primary key,
enterpriseProperty varchar(6),
productionPlace varchar(6),
managementAptitude varchar(6),
taxSituation varchar(6),
goodsSale varchar(6),
enterpriseFoungingTime varchar(6),
threshold varchar(6)
);

/*商贸业经营情况 commerce
  1.企业产权制度					enterpriseProperty
  2.主要经营场所位置					mainProductionPlace
  3.与主要代理销售商品生产厂家的合作关系	partnership
  4.商品销售网络或渠道				goodsSale
  5.企业成立时间					enterpriseFoungingTime
  6.销售商品的知名度					goodsPopularity
  7.代理级别						proxyLevel
  8.商品存放						goodsStorage
  9.纳税情况						taxSituation
 10.行业门槛						threshold
*/
create table commerce(
customerNum varchar(8) primary key,
enterpriseProperty varchar(6),
mainProductionPlace varchar(6),
partnership varchar(6),
goodsSale varchar(6),
enterpriseFoungingTime varchar(6),
goodsPopularity varchar(6),
proxyLevel varchar(6),
goodsStorage varchar(6),
taxSituation varchar(6),
threshold varchar(6)
);