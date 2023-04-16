create database class_monhoc;
create table class_monhoc(
code_class int,
name_class varchar(255)
);
select * from class_monhoc;
insert into class_monhoc(code_class,name_class)
value(1,"Physic");
update class_monhoc
set name_class = "Chemistry"
where code_class = 1;