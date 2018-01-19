package com.kabank.mvc.dao.impl;

import com.kabank.mvc.dao.AccountDAO;
import com.kabank.mvc.decorate.ExcuteQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.query.member.LoginQuery;

public class AccountDAOImpl implements AccountDAO{
	public static AccountDAOImpl getInstance() {
		return new AccountDAOImpl();
	}
	public AccountDAOImpl() {}
	@Override
	public AccountBean selectAccountByID() {
		return (AccountBean)new ExcuteQuery(new LoginQuery()).execute();
/*		System.out.println("===MEMBER.D: LOGIN IN===");
		StringBuffer sql=new StringBuffer(MemberEnum.LOGIN.toString());
		String[] arr=InitCommand.cmd.getData().split("/");
		System.out.println("ID : "+arr[0]);
		System.out.println("pass : "+arr[1]);
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, arr[0]);
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, arr[1]);
		System.out.println("::SQL::"+sql.toString());
		MemberBean member=null;
		try {
			ResultSet rs=DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeQuery(sql.toString());
			while(rs.next()) {
				member =new MemberBean();
				member.setId(rs.getString(MemberEnum.ID.toString()));
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				member.setName(rs.getString(MemberEnum.NAME.toString()));
				member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				member.setAddr(rs.getString(MemberEnum.ADDR.toString()));
				member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				member.setSsn(rs.getString(MemberEnum.SSN.toString()));
				member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
			}
			System.out.println("담긴 맴버 "+member);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return member;
*/	}
}
