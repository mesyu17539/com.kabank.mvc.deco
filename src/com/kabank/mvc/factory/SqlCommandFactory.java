package com.kabank.mvc.factory;

import java.util.Map;

import com.kabank.mvc.command.InitCommand;

public class SqlCommandFactory {
	public static String sqlcreate(Map<?,?> map) {
		String foo="";
		String arr[]=InitCommand.cmd.getColum().split(",");
		for(int i=0;i<arr.length;i++) {
			foo=foo.concat("'");
			foo+=map.get(arr[i]);
			foo=foo.concat("'");
			if(i<arr.length-1) {
				foo=foo.concat(",");
			}
		}
		System.out.println("sqlComand 소환할 쿼리문 "+foo);
		return foo;
	}
	static String sqlcreate(int bar) {
		String foo="";
		for(int i=0;i<bar;i++) {
			foo=foo.concat("%s");
			if(i<bar-1) {
				foo=foo.concat(",");
			}
		}
		System.out.println("sqlComand 소환할 쿼리문"+foo);
		return foo;
	}
}
