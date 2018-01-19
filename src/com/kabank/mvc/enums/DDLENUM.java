package com.kabank.mvc.enums;

public enum DDLENUM {
	CREATE_TABLE_MEMBER(){
		public String toString() {
			return "CREATE TABLE "
					+"MEMBER"
					+"("
					+" ID VARCHAR2(20) PRIMARY KEY,"
					+" pass VARCHAR2(20), "
					+" name VARCHAR2(20), "
					+" ssn VARCHAR2(20), "
					+" phone VARCHAR2(20), "
					+" email VARCHAR2(20), "
					+" profile VARCHAR2(20), "
					+" addr VARCHAR2(20) "
					+")";
		}
	},
	CREATE_TABLE_ATTEND(){
		@Override
		public String toString() {
			return "CREATE TABLE "
					+"ATTEND"
					+"("
					+" ID VARCHAR2(20) PRIMARY KEY,"
					+" pass VARCHAR2(20), "
					+" name VARCHAR2(20), "
					+" ssn VARCHAR2(20), "
					+" phone VARCHAR2(20), "
					+" email VARCHAR2(20), "
					+" profile VARCHAR2(20), "
					+" addr VARCHAR2(20) "
					+")";
		}
	},
	CREATE_TABLE_MOBILE(){
		@Override
		public String toString() {
			return "create table MOBILE(" + 
					"customer_Num varchar2(20) primary key," + 
					"user_id varchar2(20)," + 
					"phone varchar2(20)," + 
					"regdate date," + 
					"foreign key(user_id) references member(id) on delete cascade)"
					;
		}
	},
	CREATE_TABLE_RULE(){
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "create sequence customer_Num start with 1000";
		}
	},
	CREATE_TABLE_BANK(){
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return  "create table bank(" + 
					"customer_Num varchar2(20) primary key," + 
					"account_Num varchar2(20) not null," + 
					"money varchar2(20) default 0," + 
					"id varchar2(20)," + 
					"foreign key(id) references member(id) on delete cascade)"
					;
		}
	}
}
