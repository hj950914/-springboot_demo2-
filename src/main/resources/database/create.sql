create database springboot_demo2;

create table picture(
id int auto_increment primary key ,
pic blob comment '照片',
description varchar(200) comment '描述'
)ENGINE=InnoDB,default charset=utf8;