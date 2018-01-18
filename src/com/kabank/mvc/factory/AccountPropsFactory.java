package com.kabank.mvc.factory;

public class AccountPropsFactory {
	public static String create(Object[] o) {
		String foo="";
		for(int i=0;i<o.length;i++) {
			System.out.println("o["+i+"]"+o[i]);
			foo+=o[i];
			if(i<o.length-1) {
				foo=foo.concat(",");
			}
		}
		System.out.println("========팩토리"+foo);
		return foo;
	}
}
