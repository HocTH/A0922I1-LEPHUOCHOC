create database demo;
use demo;
create table Products(
Id int not null primary key,
productCode int not null,
productName varchar(255) not null,
productPrice double not null,
productAmount int not null,
productDescription varchar(255) not null , 
productStatus varchar(255));
insert into products
value(1,123,"laptop",1000,100,"new",1);
insert into products
value(2,143,"chai nuoc",1040,140,"old",1);
insert into products
value(3,153,"ban",14000,1400,"normal",1);
insert into products
value(5,12443,"sac",15000,1500,"new",1);
create unique index index_productCode on products(productCode);
create  index index_productNamePrice on products(productName,productPrice);
explain select* from products
where productCode = 1243;

create view informationProduct
as select productCode, productName, productPrice, productStatus from  products;
select * from informationProduct;
alter view informationProduct
as select id,productCode, productName, productPrice, productStatus from  products;
drop view informationProduct;
#Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
#Tạo store procedure thêm một sản phẩm mới
#Tạo store procedure sửa thông tin sản phẩm theo id
#Tạo store procedure xoá sản phẩm theo id

delimiter $$
create procedure getInfor()
begin 
select * from products;
end $$
delimiter ;
call getInfor();

delimiter $$
create procedure addProduct(in Id int,
in productCode int ,
in productName varchar(255) ,
in productPrice double,
in productAmount int ,
in productDescription varchar(255), 
in productStatus varchar(255))
begin 
insert into products
value(id,productCode, productName,productPrice,productAmount,productDescription,productStatus )
;
end $$
delimiter ;
drop procedure addProduct;
call addProduct(6,124463,"sadc",15000,15040,"new1",1);
