package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.TelecomBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.TelecomProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.util.Enums.DML;
import com.kabank.mvc.util.Enums.TABLE;

public class LoginMQuery implements IQuery{
	PreparedStatement pstmt;
	public LoginMQuery() {
		System.out.println("로그인M 쿼리");
		try {
			pstmt=DatabaseFactory.create(Vendor.ORACLE)
			.getConnection().prepareStatement(
					DML.SELECT
					+" "
					+"CUSTOMER_NUM as CUSTOMER_NUM,"
					+"PHONE as PHONE,"
					+"REGDATE as REGDATE"
					+" "
					+DML.FROM
					+" "
					+TABLE.MOBILE
					+" "
					+DML.WHERE
					+" "
					+"id LIKE ?");
			System.out.println("이닛 데이터"+InitCommand.cmd.getData());
			pstmt.setString(1, InitCommand.cmd.getData().split("/")[0]);
			System.out.println("전번 까라"+
					DML.SELECT
					+" "
					+"CUSTOMER_NUM as CUSTOMER_NUM,"
					+"PHONE as PHONE,"
					+"REGDATE as REGDATE"
					+" "
					+DML.FROM
					+" "
					+TABLE.MOBILE
					+" "
					+DML.WHERE
					+" "
					+"user_id LIKE "+InitCommand.cmd.getData().split("/")[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("로그인 쿼리M out");
	}
	@Override
	public Object execute() {
		TelecomBean bean=null;
		System.out.println("try");
		try {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("while");
				bean =new TelecomBean();
				bean.setCustomerNum(rs.getString(TelecomProps.CUSTOMER_NUM.toString()));
				bean.setPhone(rs.getString(TelecomProps.PHONE.toString()));
				bean.setRegDate(rs.getString(TelecomProps.REGDATE.toString()));
				System.out.println("폰회원정보"+bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
}
