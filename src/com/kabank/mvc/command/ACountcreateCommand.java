package com.kabank.mvc.command;

import java.sql.SQLException;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.Iterator.ParamIterator;
import com.kabank.mvc.dao.impl.KakaoDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.factory.AccountPropsFactory;
import com.kabank.mvc.factory.SqlCommandFactory;

public class ACountcreateCommand implements IOrder{
	Map<?,?> map;
	HttpSession session;
	public ACountcreateCommand(HttpServletRequest request) {
		map=ParamIterator.execute(request);
		session=request.getSession();
	}
	@Override
	public void execute() {
		InitCommand.cmd.setColum(
				/*"customer_Num,account_Num,money,id"*/
				AccountPropsFactory.create(AccountProps.values()));
		String str="";
		for(int i=0;i<8;i++) {
			str+=String.valueOf(new Random().nextInt(9));
			if(i==3) {
				str+="-";
			}
		}
		InitCommand.cmd.setData(
				String.format("customer_Num.nextval,'"+str+"','0',"+"'"+((MemberBean)session.getAttribute("user")).getId()+"'"));
		System.out.println("살았다\n"
				+ "쿼리 조합문 : "	+InitCommand.cmd.getData()
				+"\n 프롭크기 알아보자"+AccountProps.values().length
				+"\n 프롭값들 알아보자"+AccountProps.values().toString()
				);
	}
	
}
