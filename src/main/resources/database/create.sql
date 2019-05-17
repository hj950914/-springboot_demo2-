create database springboot_demo2;
use springboot_demo2;
create table picture(
id int auto_increment primary key ,
pic longblob comment '照片',
description varchar(200) comment '描述'
)ENGINE=InnoDB,default charset=utf8;


-- 数据表优化设计,把图片的路径存入数据库,图片存到本地(使用Nginx的静态资源加载)
create table picture_best(
pid int auto_increment primary key,
path varchar (100) comment '照片本地路径'
)ENGINE=InnoDB,default charset=utf8;