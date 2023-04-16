create database class_monhoc;
create table class_monhoc(
code_class int,
name_class varchar(255)
);
select * from class_monhoc;
insert into class_monhoc(code_class,name_class)
value(12,"Physic");
update class_monhoc
set name_class = "Chemistry"
where code_class = 1;
delete from class_monhoc
where code_class = 1 ;
alter table class_monhoc
add column mark int;
