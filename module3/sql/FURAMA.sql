CREATE DATABASE FURAMA;
use furama;
CREATE TABLE vi_tri(
ma_vi_tri int primary key,
ten_vi_tri varchar(255)
);
CREATE TABLE TRINH_DO(
ma_trinh_do int primary key,
ten_trinh_do varchar(255)
);
CREATE TABLE BO_PHAN(
ma_bo_phan int primary key,
ten_bo_phan varchar(255)
);
CREATE TABLE nhan_vien(
ma_nhan_vien int primary key,
ho_ten varchar(255),
ngay_sinh datetime,
so_cmnd varchar(255),
luong double,
so_dien_thoai varchar(10),
email varchar(255),
dia_chi varchar(255),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);
CREATE TABLE loai_khach(
ma_loai_khach int primary key,
ten_loai_khach varchar(255)
);
CREATE TABLE kieu_thue(
ma_kieu_thue int primary key,
ten_kieu_thue varchar(255)
);
CREATE TABLE loai_dich_vu(
ma_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(255)
);
CREATE TABLE khach_hang(
ma_khach_hang int primary key,
ma_loai_khach int,
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach),
ho_ten varchar(255),
ngay_sinh datetime,
gioi_tinh bit(1),
so_cmnd varchar(255),
so_dien_thoai varchar(10),
email varchar(255),
dia_chi varchar(255)
);
CREATE TABLE hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);
CREATE TABLE dich_vu_di_kem(
ma_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(255),
gia double,
don_vi varchar(255),
trang_thai varchar(255)
);
CREATE TABLE hop_dong(
ma_hop_dong int primary key,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);
CREATE TABLE DICH_VU(
ma_dich_vu int primary key,
ten_dich_vu varchar(255),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(255),
mo_ta_tien_nghi_khac varchar(255),
dien_tich_ho_boi double,
so_tang int,
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

insert into vi_tri
value(1,"Quản lý");
insert into vi_tri
value(2,"Nhân viên");

insert into trinh_do
value(1,"Trung cấp");
insert into trinh_do
value(2,"Cao đẳng");
insert into trinh_do
value(3,"Đại học");
insert into trinh_do
value(4,"Sau Đại học");

 insert into bo_phan
 value(1,"sale-marketing");
  insert into bo_phan
 value(2,"hành chính");
  insert into bo_phan
 value(3,"phục vụ");
  insert into bo_phan
 value(4,"quản lí");
 insert into nhan_vien
 value(1,"Nguyễn Văn An","1970-11-07","456231786",10000000.0,"0901234121","annguyen@gmail.com","295 Nguyễn Tất Thành,Đà Nẵng ",1,3,1);
  insert into nhan_vien
 value(2,"Lê Văn Bình","1997-04-09","654231234",7000000,"0934212314","binhlv@gmail.com","22 Yên Bái, Đà Nẵng",1,2,2);
   insert into nhan_vien
 value(3,"Hồ Thị Yến","1995-12-12","999231723",14000000,"0412352315","thiyen@gmail.com","K234/11 Điện Biên Phủ, Gia Lai",1,3,2);
    insert into nhan_vien
 value(4,"Võ Công Toản","1980-04-04","123231365",17000000,"0374443232","toan0404@gmail.com","77 Hoàng Diệu, Quảng Trị",1,4,4);
  insert into nhan_vien
 value(5,"Nguyễn Bỉnh Phát","1999-12-09","454363232",6000000,"0902341231","phatphat@gmail.com","43 Yên Bái, Đà Nẵng",2,1,1);
   insert into nhan_vien
 value(6,"Khúc Nguyễn An Nghi","2000-11-08","964542311",7000000,"0978653213","annghi20@gmail.com","294 Nguyễn Tất Thành, Đà Nẵng",2,2,3);
   insert into nhan_vien
 value(7,"Nguyễn Hữu Hà","1993-01-01","534323231",8000000,"0941234553","nhh0101@gmail.com","4 Nguyễn Chí Thanh, Huế",2,3,2);
   insert into nhan_vien
 value(8,"Nguyễn Hà Đông","1989-09-03","234414123",9000000,"0642123111","donghanguyen@gmail.com","111 Hùng Vương, Hà Nội",2,4,4);
   insert into nhan_vien
 value(9,"Tòng Hoang","1982-09-03","256781231",6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4);
   insert into nhan_vien
 value(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
 
 insert into loai_khach
 value(1,"Diamond");
  insert into loai_khach
 value(2,"Platinium");
  insert into loai_khach
 value(3,"gold");
  insert into loai_khach
 value(4,"silver");
  insert into loai_khach
 value(5,"member");
 
insert into khach_hang
value( 1,5,"Nguyễn Thị Hào","1970-11-07",0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng');
insert into khach_hang
value(2,3,'Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị');
insert into khach_hang
value(3,1,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh');
insert into khach_hang
value( 4,1,'Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng');
insert into khach_hang
value( 5,4,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai');
insert into khach_hang
value( 6,4,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng');
insert into khach_hang
value( 7,1,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh');
insert into khach_hang
value( 8,3,'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum');
insert into khach_hang
value(9,1,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi');
insert into khach_hang
value( 10,2,'Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng');

insert into kieu_thue
value(1,'year');
insert into kieu_thue
value(2,'month');
insert into kieu_thue
value(3,'day');
insert into kieu_thue
value(4,'house');

insert into loai_dich_vu
value(1,"villa");
insert into loai_dich_vu
value(2,"house");
insert into loai_dich_vu
value(3,"room");

insert into dich_vu_di_kem
value(1,"karaoke",10000,"giờ","tiện nghi hiện tại");
insert into dich_vu_di_kem
value(2,"thuê xe máy",10000,"chiếc","hỏng 1 xe");
insert into dich_vu_di_kem
value(3,"thuê xe đạp",20000,"chiếc","tốt");
insert into dich_vu_di_kem
value(4,"Buffet buổi sáng",15000,"suất","đầy đủ đồ ăn, tráng miệng");
insert into dich_vu_di_kem
value(5,"Buffet buổi trưa",90000,"suất","đầy đủ đồ ăn, tráng miệng");
insert into dich_vu_di_kem
value(6,"Buffet buổi tối",16000,"suất","đầy đủ đồ ăn, tráng miệng");

insert into hop_dong 
value(1,'2020-12-08','2020-12-08',0,3,1,3);
insert into hop_dong 
value(2,'2020-07-14','2020-07-21',200000,7,3,1);
insert into hop_dong 
value(3,'2021-03-15','2021-03-17',50000,3,4,2);
insert into hop_dong 
value(4,'2021-01-14','2021-01-18',100000,7,5,5);
insert into hop_dong 
value(5,'2021-07-14','2021-07-15',0,7,2,6);
insert into hop_dong 
value(6,'2021-06-01','2021-06-03',0,7,7,6);
insert into hop_dong 
value(7,'2021-09-02','2021-09-05',100000,7,4,4);
insert into hop_dong 
value(8,'2021-06-17','2021-06-18',150000,3,4,1);
insert into hop_dong 
value(9,'2020-11-19','2020-11-19',0,3,4,3);
insert into hop_dong 
value(10,'2021-04-12','2021-04-14',0,10,3,5);
insert into hop_dong 
value(11,'2021-04-25','2021-04-25',0,2,2,1);
insert into hop_dong 
value(12,'2021-05-25','2021-05-27',0,7,10,1);

insert into hop_dong_chi_tiet
value(1,2,4,5);
insert into hop_dong_chi_tiet
value(2,2,5,8);
insert into hop_dong_chi_tiet
value(3,2,6,15);
insert into hop_dong_chi_tiet
value(4,3,1,1);
insert into hop_dong_chi_tiet
value(5,3,2,11);
insert into hop_dong_chi_tiet
value(6,3,1,1);
insert into hop_dong_chi_tiet
value(7,1,2,2);
insert into hop_dong_chi_tiet
value(8,12,2,2);
insert into dich_vu
value(1,'Villa Beach Front',25000,10000000,10,3,1,'vip','Có hồ bơi',500,4);
insert into dich_vu
value(2,'House Princess 01',14000,5000000,7,2,2,'vip','Có thêm bếp nướng',null,3);
insert into dich_vu
value(3,'Room Twin 01',5000,1000000,2,4,3,'normal','Có tivi',null,null);
insert into dich_vu
value(4,'Villa No Beach Front',22000,9000000,8,3,1,'normal','Có hồ bơi',300,3);
insert into dich_vu
value(5,'House Princess 02',10000,4000000,5,3,2,'normal','Có thêm bếp nướng',null,2);
insert into dich_vu
value(6,'Room Twin 02',3000,900000,2,4,3,'normal','Có tivi',null,null);
#cau2
select * from nhan_vien
where (ho_ten like "h%" or ho_ten like "t%" or ho_ten like "k%") and length (nhan_vien.ho_ten)<=16;
#cau3
select * from khach_hang
where (timestampdiff(year,ngay_sinh,now()) between 18 and 50) and (dia_chi like "%Đà Nẵng" or dia_chi like "%Quảng Trị" );
#cau4
select khach_hang.ma_khach_hang, ho_ten,count(khach_hang.ma_khach_hang) as so_lan_dat_phong 
from khach_hang join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
group by khach_hang.ma_khach_hang,ten_loai_khach
having  ten_loai_khach = "diamond"
order by so_lan_dat_phong asc;
#cau5
select khach_hang.ma_khach_hang, ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, ten_dich_vu,
ngay_lam_hop_dong,ngay_ket_thuc, sum(ifnull(chi_phi_thue,0) +(ifnull( hop_dong_chi_tiet.so_luong,0)*ifnull(dich_vu_di_kem.gia,0))) as tong_tien
from khach_hang  left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join dich_vu  on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on  hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem 
group by hop_dong.ma_hop_dong,khach_hang.ma_khach_hang;

/*sum(
 case 
 when hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia is null then dich_vu.chi_phi_thue
 else hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia + dich_vu.chi_phi_thue
 end) as tong ;
 */
 #cau6
 select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
 from hop_dong  join dich_vu on hop_dong.ma_dich_vu =  dich_vu.ma_dich_vu join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
 where dich_vu.ma_dich_vu != all( select dich_vu.ma_dich_vu from dich_vu join hop_dong  on hop_dong.ma_dich_vu =  dich_vu.ma_dich_vu  where (month(ngay_lam_hop_dong) between  1 and 3 ) and  year(ngay_lam_hop_dong) = 2021 )
 group by dich_vu.ma_dich_vu
 order by loai_dich_vu.ten_loai_dich_vu desc;
 #cau 7
  select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
 from hop_dong  join dich_vu on hop_dong.ma_dich_vu =  dich_vu.ma_dich_vu join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
 where dich_vu.ma_dich_vu != all( select dich_vu.ma_dich_vu from dich_vu join hop_dong  on hop_dong.ma_dich_vu =  dich_vu.ma_dich_vu  where  year(ngay_lam_hop_dong) = 2021 )
  and year(ngay_lam_hop_dong) =2020
 group by dich_vu.ma_dich_vu
 order by loai_dich_vu.ten_loai_dich_vu desc;
 #cau 8
select ho_ten from khach_hang
group by ho_ten
having count(ho_ten)>1;
#cau 9
select  month(ngay_lam_hop_dong) as thang, count(month(ngay_lam_hop_dong)) as so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by thang ;
#cau 10
select hop_dong.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, 
sum(case when hop_dong_chi_tiet.so_luong is null then 0 else hop_dong_chi_tiet.so_luong end) as so_luong
from hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;
#cau 11
select dich_vu_di_kem.ma_dich_vu_di_kem, ten_dich_vu_di_kem
from khach_hang join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where ten_loai_khach = "Diamond" and (dia_chi like "%vinh" or dia_chi like "%Quảng Ngãi")
order by ma_dich_vu_di_kem;
# cau 12
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten,khach_hang.so_dien_thoai, ten_dich_vu,tien_dat_coc,sum(hop_dong_chi_tiet.so_luong)
from khach_hang left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu =  dich_vu.ma_dich_vu
left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where nhan_vien.ho_ten is not null and month(ngay_lam_hop_dong) >8 and year(ngay_lam_hop_dong) = 2020
group by hop_dong.ma_hop_dong,ten_dich_vu





 


































































































































































































