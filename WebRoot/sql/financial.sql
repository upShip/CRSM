/*������� financial*/
/*
1.��ģָ��		scaleIndex
2.��ծ����		sovency
3.��Ӫ����		capaxNegotii
4.��ӪЧ��		managementBenefit
*/
create table financial(
customerNum varchar(8) primary key,
scaleIndex varchar(6),
sovency varchar(6),
capaxNegotii varchar(6),
managementBenefit varchar(6)
);


/*������� creditSituation*/
/*  
1.��ҵ��ʵ�ʿ����������н�������ҵ��ʱ��	creditTime
2.���ŷ�����ƣ��̶��ʲ����������ָ�꣩	creditScheme
3.�����						loanDepositRatio
*/
create table credit(
customerNum varchar(8) primary key,
creditTime varchar(6),
creditScheme varchar(10),
loanDepositRatio varchar(10)
);


/*ͨ����ҵ��Ӫ��� generalIndustry
  1.��ҵ��Ȩ�ƶ�		enterpriseProperty
  2.������Ӫ����		productionPlace
  3.��Ӫ�������		managementAptitude
  4.��˰���			taxSituation
  5.��Ʒ�������������	goodsSale
  6.��ҵ����ʱ��		enterpriseFoungingTime
  7.��ҵ�ż�			threshold
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

/*��óҵ��Ӫ��� commerce
  1.��ҵ��Ȩ�ƶ�					enterpriseProperty
  2.��Ҫ��Ӫ����λ��					mainProductionPlace
  3.����Ҫ����������Ʒ�������ҵĺ�����ϵ	partnership
  4.��Ʒ�������������				goodsSale
  5.��ҵ����ʱ��					enterpriseFoungingTime
  6.������Ʒ��֪����					goodsPopularity
  7.������						proxyLevel
  8.��Ʒ���						goodsStorage
  9.��˰���						taxSituation
 10.��ҵ�ż�						threshold
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