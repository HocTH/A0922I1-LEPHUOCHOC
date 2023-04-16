CREATE database quanlysanpham;
use quanlysanpham;
create table Customer(
cID int not null,
cName varchar(255) not null,
cAge int not null,
primary key(cID)
);
create table Order1(
oID int not null,
cID int not null,
oDate datetime not null,
oTotalPrice int default 0,
foreign key (cID) references Customer(cID), 
primary key (oID)
);
create table Product(
pID int not null,
pName varchar(255) not null,
pPrice int default 0,
primary key (pID)
);
create table OrderDetail(
oID int not null,
pID int not null,
foreign key(oID) references  Order1(oID),
foreign key(pID) references  Product(pID)
);
insert into Customer
value (1,"Minh Quan",10);
insert into Customer
value (2,"Ngoc Anh",20);
insert into Customer
value (3,"Hong Ha",50);
insert into Customer
value (4,"Hoc Tinh",50);

insert into order1
value(1,1,"2006-03-21",0);
insert into order1
value(2,2,"2006-3-23",0);
insert into order1
value(3,1,"2006-03-16",0);

insert into product
value (1,"may giat",3);
insert into product
value (2,"tu lanh",5);
insert into product
value (3,"dieu hoa",7);
insert into product
value (4,"may tinh",1);
insert into product
value (5,"Tv",10);

alter table orderdetail
add column odQty int not null;
select oid,odate,ototalprice
from order1;
select customer.cname,pname
from customer join order1 on customer.cid = order1.cid join orderdetail on order1.oid = orderdetail.oid join product on orderdetail.pid = product.pid;
 select customer.cid,cname,oid
from customer left join order1 on customer.cid = order1.cid
having order1.oid is null;

SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));


select cname,Order1.oid, odate, sum(OrderDetail.odQTY*Product.pPrice) as Total from customer 
join order1  on customer.cid = order1.cid 
join orderdetail on order1.oid = orderdetail.oid 
join product on orderdetail.pid = product.pid
group by oid;


