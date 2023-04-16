SELECT * FROM management_student.hoc;
insert into hoc(idhoc,name,address)
value(124,"ngia","hn");
select* from hoc;
insert into hoc(idhoc,name,address)
value(1254,"ngia","hn");
insert into hoc(idhoc,name,address)
value(12543,"ngia","hn");
update hoc
set name = "tinh"
where idhoc = 124;
delete from hoc
where idhoc = 124;
alter table hoc
add column mark int;
select * from hoc;