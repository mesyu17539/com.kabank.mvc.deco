package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.Iterator.ParamIterator;
import com.kabank.mvc.factory.SqlCommandFactory;

public class JoinCommand implements IOrder{
	Map<?,?> map;
	public JoinCommand(HttpServletRequest request) {
		map=ParamIterator.execute(request);
	}
	@Override
	public void execute() {
		System.out.println("========JoinCo execute=========");
		System.out.println(map);
		InitCommand.cmd.setColum("id,pass,name,ssn,phone,email,profile,addr");
		InitCommand.cmd.setData(
				SqlCommandFactory.sqlcreate(map)
				/*String.format("%s/%s/%s/%s/%s/%s/%s/%s"
						,map.get("id")
						,map.get("pass")
						,map.get("name")
						,(map.get("ssn1").toString()).concat("-").concat(map.get("ssn2").toString())
						,map.get("phone1").toString().concat("-").concat(map.get("phone2").toString().concat("-").concat(map.get("phone3").toString()))
						,map.get("email").toString().concat(map.get("url").toString())
						,""
						,map.get("addr"))*/
				);
		System.out.println("========조인커멘드 정보=========");
		System.out.println(InitCommand.cmd.getColum());
		System.out.println(InitCommand.cmd.getData());
		System.out.println("========execute OUT=========");
	}
	
}
