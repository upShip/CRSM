create database card;
use card;

/*创建用户表*/
create table user(
number varchar(8) primary key,
name varchar(10),
password varchar(16),
isAdmin int/*权限位*/
);