package com.kabank.mvc.util;

public enum KakaoEnum {
	CUSTONNUM,ACCOUNTNUM,MONEY,ID,
	INSERT_BANK{
		@Override
		public String toString() {
			/*custonnum,accountnum,money,id*/
			return "INSERT INTO %s(%s)"
					+ " VALUES(%s)";
		}
	}
}
