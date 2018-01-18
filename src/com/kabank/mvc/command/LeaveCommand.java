package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.Iterator.ParamIterator;
import com.kabank.mvc.domain.MemberBean;

public class LeaveCommand implements IOrder{
	Map<?,?> map;
	HttpSession session;
	public LeaveCommand(HttpServletRequest request) {
		/*map=ParamIterator.execute(request);*/
		session=request.getSession();
		System.out.println(session.getAttribute("user"));
		System.out.println("===========Leave커멘드 MAP=============\n"+map+"\n bean");
	}
	@Override
	public void execute() {
		System.out.println("========execute==========");
		InitCommand.cmd.setColum("id/pass");
		InitCommand.cmd.setData(
				((MemberBean)session.getAttribute("user")).getId()
				+"/"
				+((MemberBean)session.getAttribute("user")).getPass());
		System.out.println(InitCommand.cmd.getColum());
		System.out.println(InitCommand.cmd.getData());
	}
	
}
