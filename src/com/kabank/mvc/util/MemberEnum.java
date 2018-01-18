package com.kabank.mvc.util;

public enum MemberEnum {
	ID, PASS,NAME,SSN,PHONE,EMAIL,PROFILE,ADDR,
	PROPERTIES{
		public String toString() {
			return ID+","+PASS+","+NAME+","+SSN+","+PHONE+","+EMAIL+","+PROFILE+","+ADDR;
		}
	},
	LOGIN{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SELECT ID, PASS,NAME,SSN,PHONE,EMAIL,ADDR,PROFILE FROM Member "
					+ "where id LIKE '$' AND pass LIKE '@'";
		}
	},
	CHANGEPASS{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "UPDATE MEMBER SET pass='@' where id LIKE '$' AND pass LIKE '&'";
		}
	},
	MEMBERDELETE{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "DELETE FROM Member where id='@'";
		}
	},
	MEMJOIN{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "INSERT INTO %s(%s) VALUES(%s)";
		}
	},
	SELECTNUM{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "select customer_Num from BANK where customer_Num='%s'";
		}
	}
}