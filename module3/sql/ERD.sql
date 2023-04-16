create database ERD;
use ERD;
create table PHIEUXUAT(
SoPX int not null,
NgayXuat datetime not null,
primary key(SoPX)
);
create table VATTU(
MaVTU int not null,
tenVTU varchar(255) not null,
primary key (MaVTU)
);
create table PHIEUNHAP(
SoPN int not null,
NgayNhap datetime not null,
primary key(SoPN)
);
create table DonDH(
SoDH int not null,
NgayDH datetime not null,
primary key(SoDH)
);
create table NHACC(
MaNCC int not null,
TenNCC varchar(255) not null,
DiaChi varchar(255),
primary key(MaNCC)
);
create table SDT(
SDT varchar(10) not null,
MaNCC int not null,
 primary key(SDT),
foreign key (MaNCC) references NHACC(MaNCC)
);
create table CHITIETPHIEUXUAT(
    MaVTU int not null,
	SoPN int not null,
    DGXuat int not null,
    SLXuat int not null,
    primary key (SoPN , MaVTU),
    foreign key (SoPN) references PHIEUNHAP(SoPN),
    foreign key (MaVTU) references VATTU(MaVTU)
    );
create table CHITIETPHIEUNHAP(
    MaVTU int not null,
	SoPN int not null,
    DGNhap int not null,
    SLNhap int not null,
    primary key (SoPN , MaVTU),
    foreign key (SoPN) references PHIEUNHAP(SoPN),
    foreign key (MaVTU) references VATTU(MaVTU)
    );
    create table CHITIETDONHANG(
    MaVTU int not null,
	SoDH int not null,
    primary key (SoDH , MaVTU),
    foreign key (SoDH) references DonDH(SoDH),
    foreign key (MaVTU) references VATTU(MaVTU)
    );
