1씩 증가하는 테이블 생성 쿼리
create sequence customer_Num start with 1000;
create table bank(
customer_Num varchar2(20) primary key,
account_Num varchar2(20) not null,
money varchar2(20) default 0,
id varchar2(20) ,
foreign key(id) references member(id)
on delete cascade);
on delete cascade 한 이유는 참조한 녀석도 같이 알아서 삭제하려고한것

SELECT b.CUSTOMER_NUM as CUSTOMER_NUM,b.PHONE as PHONE,b.REGDATE as REGDATE
FROM MEMBER m, MOBILE b WHEREm.id LIKE 'sangwoo' AND m.pass LIKE 12 AND m.id LIKE b.USER_ID
SELECT b.CUSTOMER_NUM as CUSTOMER_NUM,b.PHONE as PHONE,b.REGDATE as REGDATE 
FROM MEMBER m, MOBILE b 
WHERE m.id LIKE 'sangwoo' AND m.pass LIKE 12 AND m.id LIKE b.USER_ID;

create table MOBILE(customer_Num varchar2(20) primary key,user_id varchar2(20),phone varchar2(20),regdate date,foreign key(user_id) references member(id) on delete cascade);
INSERT INTO MOBILE(CUSTOMER_NUM,USER_ID,PHONE,REGDATE) VALUES(customer_Num.nextval,'sangwoo','010-8070-1226',sysdate)
INSERT INTO MOBILE(CUSTOMER_NUM,USER_ID,PHONE,REGDATE) VALUES(customer_Num.nextval,'sangwoo','010-8070-1226',sysdate)
select * from mobile;

SELECT CUSTOMER_NUM as CUSTOMER_NUM,PHONE as PHONE,REGDATE as REGDATE FROM MOBILE WHERE user_id LIKE 'sangwoo'

select * from tab;
select * from bank;
select * from MEMBER;
INSERT INTO MOBILE(CUSTOMER_NUM,USER_ID,PHONE,REGDATE) VALUES(customer_Num.nextval,'sangwoo','010-2285-3586',sysdate);
INSERT INTO BANK(customer_Num,account_Num,money,id) VALUES(customer_Num.nextval,'2234-1234','1','sangwoo')

drop table MEMBER;
drop table MOBILE;
drop sequence customer_Num;


INSERT INTO BANK(customer_Num,id) VALUES(customer_Num.nextval,'sangwoo')

toad 전용
desc member;
desc bank;


DELETE FROM MEMBER WHERE id LIKE sangwoo1 AND pass LIKE 12
DELETE FROM MEMBER WHERE id LIKE sis;
 OR id LIKE 111 OR id LIKE sis OR id LIKE sya
관계대수 릴레이션 알고리즘이다
select 
	b.customer_Num as 고객번호,
	m.id as 아이디,
	m.pass as 비밀번호,
	m.name as 이름,
	m.phone as 전화번호,
	m.email as 이메일,
	m.profile as 프로필,
	m.addr as 주소,
	m.ssn as 주민번호,
	b.account_Num as 계좌번호,
	b.money as 계좌금액 
from member m, bank b 
where m.id = b.id 
order by b.customer_Num desc;
역순
order by b.customer_Num asc;
오름차순 디폴트

수정편
SELECT 
    b.customer_Num as customer_Num,
	m.id as id,
	m.pass as pass,
	m.name as name,
	m.phone as phone,
	m.email as email,
	m.profile as profile,
	m.addr as addr,
	b.account_Num as account_Num,
	b.money as money 
FROM MEMBER m,BANK b 
WHERE m.id LIKE 'sangwoo' AND m.pass LIKE 12 AND m.id LIKE b.id;

INSERT INTO BANK(customer_Num,account_Num,money,id) VALUES('자동증가','랜덤','0','sangwoo');
select account_Num from BANK where account_Num=121;


SELECT b.customer_Num as 고객번호,m.id as 아이디,m.pass as 비밀번호,m.name as 이름,m.phone as 전화번호,m.email as 이메일,m.profile as 프로필,m.addr as 주소,b.account_Num as 계좌번호,b.money as 계좌금액  FROM MEMBER m,BANK b WHERE id LIKE sangwoo AND pass LIKE 12

