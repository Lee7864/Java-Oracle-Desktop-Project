select * from tblMember;


delete from tblMember
where idx = 76;

--테이블 생성
create table joiner(
idx number,
userID  varchar(20) primary key,
userPassword  varchar(20),
userPassword1 varchar(20),
username varchar(20)
);

select * from joiner;

drop table joiner;