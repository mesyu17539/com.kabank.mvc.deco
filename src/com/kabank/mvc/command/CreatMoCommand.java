package com.kabank.mvc.command;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.TelecomProps;
import com.kabank.mvc.factory.AccountPropsFactory;

public class CreatMoCommand implements IOrder{
	HttpSession session;
	public CreatMoCommand(HttpServletRequest request) {
		session=request.getSession();
	}

	@Override
	public void execute() {
		InitCommand.cmd.setColum(AccountPropsFactory.create(TelecomProps.values()));
		String str="010-";
		for(int i=0;i<8;i++) {
			str+=String.valueOf(new Random().nextInt(9));
			if(i==3) {
				str+="-";
			}
		}
		InitCommand.cmd.setData(
				String.format("customer_Num.nextval,'"+((MemberBean)session.getAttribute("user")).getId()+"','")+str+"',sysdate");
		System.out.println(InitCommand.cmd.getData());
	}
}
