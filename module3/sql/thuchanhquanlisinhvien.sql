create database QuanLySinhVien1;
use QuanLySinhVien1;
create table Class(
ClassID int not null auto_increment primary key,
ClassName varchar(255) not null,
StartDate datetime not null,
Status bit
);
create table Student(
StudentID int not null auto_increment primary key,
StudentName varchar(255) not null,
Address varchar(255),
Phone varchar(255),
Status bit,
ClassID int not null,
foreign key (ClassID) references class(ClassID)
);
create table Subject(
SubId int not null auto_increment primary key,
subName varchar(255) not null,
credit tinyint not null default 1 check ( credit >=1),
Status bit default 1
);
CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);
