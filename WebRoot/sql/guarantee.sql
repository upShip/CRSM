/*担保情况*/
/*
1.企业法人保证担保
2.抵押担保（只能输入一个文本框）
3.质押担保
4.担保公司担保
*/

create table guarantee(
customerNum varchar(8) primary key,
juridicalPerson varchar(6),
mortgage varchar(6),
impawn varchar(6),
guaranteeCorporation varchar(6)
);