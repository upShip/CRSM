create database card;
use card;

/*�����û���*/
create table user(
number varchar(8) primary key,
name varchar(10),
password varchar(16),
isAdmin int/*Ȩ��λ*/
);