package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.Iterator.ParamIterator;
import com.kabank.mvc.domain.MemberBean;

public class SearchSessionCommand implements IOrder{
	Map<?,?> map;
	HttpSession session;
	public SearchSessionCommand(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		map=ParamIterator.execute(request);
		session=request.getSession();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("=======서치 익큐트========");
		System.out.println("===========맵 저장 데이터들"+map);
		String id=String.valueOf(map.get("id"));//id는 login jsp 의 name:id.
		InitCommand.cmd.setColum("id/pass/newpass");
		InitCommand.cmd.setData(((MemberBean)session.getAttribute("user")).getId().concat("/").concat(String.valueOf(map.get("nowpass"))).concat("/").concat(String.valueOf(map.get("newpass1"))));
		System.out.println("서치커멘드 데이터"+InitCommand.cmd.getData());
	}
}

