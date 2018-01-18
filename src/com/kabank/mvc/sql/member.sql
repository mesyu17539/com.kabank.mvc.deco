1씩 증가하는 테이블 생성 쿼리
create sequence customer_Num start with 1000;
create table bank(
customer_Num varchar2(20) primary key,
account_Num varchar2(20) not null,
money varchar2(20) default 0,
id varchar2(20) ,
foreign key(id) references member(id) on delete cascade);


drop table bank;
drop sequence customer_Num;

INSERT INTO BANK(customer_Num,account_Num,money,id) VALUES(customer_Num.nextval,'2234-1234','1','sangwoo')
INSERT INTO BANK(customer_Num,id) VALUES(customer_Num.nextval,'sangwoo')

select * from tab;
select * from bank;
select * from MEMBER;

toad 전용
desc member;
desc bank;

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
	b.account_Num as 계좌번호,
	b.money as 계좌금액 
from member m, bank b 
where m.id = b.id 
order by b.customer_Num desc;
역순
order by b.customer_Num asc;
오름차순 디폴트

INSERT INTO BANK(customer_Num,account_Num,money,id) VALUES('자동증가','랜덤','0','sangwoo');
select account_Num from BANK where account_Num=121;


SELECT b.customer_Num as 고객번호,m.id as 아이디,m.pass as 비밀번호,m.name as 이름,m.phone as 전화번호,m.email as 이메일,m.profile as 프로필,m.addr as 주소,b.account_Num as 계좌번호,b.money as 계좌금액  FROM MEMBER m,BANK b WHERE id LIKE sangwoo AND pass LIKE 12

