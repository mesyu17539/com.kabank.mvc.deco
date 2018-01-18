package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.Iterator.ParamIterator;

public class SearchSessionCommand implements IOrder{
	Map<?,?> map;
	public SearchSessionCommand(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		map=ParamIterator.execute(request);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("=======서치 익큐트========");
		System.out.println("===========맵 저장 데이터들"+map);
		String id=String.valueOf(map.get("id"));//id는 login jsp 의 name:id.
		String pass=String.valueOf(map.get("nowpass"));//pass는 login jsp 의 name:pass.
		String newpass=String.valueOf(map.get("newpass1"));
		System.out.println("서치 id/pass/newpass : "+id+pass+newpass);
		InitCommand.cmd.setColum("id/pass/newpass");
		InitCommand.cmd.setData(id+"/"+pass+"/"+newpass);
	}
}

