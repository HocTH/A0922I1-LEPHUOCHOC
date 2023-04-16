CREATE database quanlydiemthi;
use quanlydiemthi;
create table hocsinh(
MaHS varchar(255) primary key,
TenHS varchar(255),
NgaySinh datetime,
Lop varchar(255),
GT varchar(255)
);
create table MonHoc(
MaMH varchar(255) PRIMARY KEY,
TenMH varchar(255)
);
create table BangDiem(
MaHS varchar(255),
MaMH varchar(255),
DiemThi int,
NgayKT datetime,
primary key(MaHS,MaMH),
foreign key(MaHS) references hocsinh(MaHS),
foreign key(MaMH) references MonHoc(MaMH)
);
create table GiaoVien(
MaGV varchar(255) primary key,
TenGV varchar(255),
SDT varchar(255)
);
alter table MonHoc add MaGV varchar(255);
alter table MonHoc add constraint FK_MaGV foreign key (MaGV)REFERENCES GiaoVien(MaGV);
drop table BangDiem;
drop table MonHoc;


