/*创建制造业经营情况*/

/*
1.企业产权制度
2.生产场所
3.水费缴纳情况
4.电费缴纳情况
5.纳税情况
6.企业成立时间
7.行业门槛
*/
create table manufacturing(
customerNum varchar(8) primary key,
enterpriseProperty varchar(6),
productionPlace varchar(6),
waterFees varchar(6),
electricityFees varchar(6),
taxSituation varchar(6),
enterpriseFoungingTime varchar(6),
threshold varchar(6)
);