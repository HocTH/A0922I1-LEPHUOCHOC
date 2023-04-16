CREATE DATABASE QuanLySinhVien12;
USE QuanLySinhVien12;
CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    Status    BIT
);
CREATE TABLE Student
(
    StudentId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);
CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
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

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
#Hiển thị danh sách tất cả học viên
SELECT *
FROM Student;

#Hiển thị danh sách học viên đang theo học
SELECT *
FROM Student
WHERE Status = true;

#Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
SELECT *
FROM Subject
WHERE Credit < 10;

#Hiển thị danh sách học viên lớp A1
SELECT StudentId, StudentName, Class.ClassName
FROM Student join Class on Student.ClassId = Class.ClassID
WHERE Class.ClassName = 'A1';

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung Mai Nguyen', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung Mai Huyen', 'Ha Noi', '0912113113', 1, 1);
#Hiển thị điểm môn CF của các học viên.
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';
select * from student
where student.StudentName like "h%";
select * from class
where month(class.StartDate) =12 ;
select * from subject
where subject.Credit between 3 and 5;
update  student
set ClassID = 2
where student.StudentName like "hung";

select StudentName, mark.mark, subject.subName
from student join mark on student.StudentId = mark.StudentId join subject on mark.subid = subject.subid
order by mark.mark desc,student.StudentName asc;

select address, count(studentId) as "so luong hoc vien"
from student
group by address;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 5;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);

select subid,subname, credit  
from subject
where credit >= (select max(credit) from subject) ;

SELECT subject.subid,subname,credit, mark.mark
from subject join mark on subject.subid = mark.subid
where mark.mark >= (select max(mark.mark) from mark); 

SELECT S.StudentId, S.StudentName,S.address,S.phone, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
order by AVG(Mark) desc;






