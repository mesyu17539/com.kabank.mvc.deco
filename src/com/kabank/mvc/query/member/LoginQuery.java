package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;
import com.kabank.mvc.util.Enums.DML;
import com.kabank.mvc.util.Enums.MemberCalum;
import com.kabank.mvc.util.Enums.TABLE;
import com.kabank.mvc.util.MemberEnum;

public class LoginQuery implements IQuery{
	PreparedStatement pstmt;
	public LoginQuery() {
		System.out.println("로그인 쿼리");
		try {
			pstmt=DatabaseFactory.create(Vendor.ORACLE)
			.getConnection().prepareStatement(
					DML.SELECT
					+" "
					+"customer_Num as customer_Num," + 
					"account_Num as account_Num," + 
					"money as money "
					+" "
					+DML.FROM
					+" "
					+TABLE.BANK
					+" "
					+DML.WHERE
					+" id LIKE ?");
				pstmt.setString(1, InitCommand.cmd.getData().split("/")[0]);
				System.out.println(DML.SELECT
						+" "
						+"customer_Num as customer_Num," + 
						"account_Num as account_Num," + 
						"money as money "
						+" "
						+DML.FROM
						+" "
						+TABLE.BANK
						+" "
						+DML.WHERE
						+" "
						+"id LIKE "+InitCommand.cmd.getData().split("/")[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("로그인 쿼리 out");
	}
	@Override
	public Object execute() {
		AccountBean account=null;
		try {
			System.out.println("===MEMBER.D: LOGIN IN===");
			/*System.out.println("로그인 쿼리 createStatement\n::SQL::"+sql.toString());*/
			/*ResultSet rs=DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeQuery(sql.toString())*/
			ResultSet rs=pstmt.executeQuery();	
			while(rs.next()) {
				System.out.println("while");
				account =new AccountBean();
				account.setAccountNum(rs.getString(AccountProps.ACCOUNT_NUM.toString()));
				System.out.println("acc"+account.getAccountNum());
				account.setCustomerNum(rs.getString(AccountProps.CUSTOMER_NUM.toString()));
				System.out.println("Cust"+account.getCustomerNum());
				account.setMoney(rs.getString(AccountProps.MONEY.toString()));
				System.out.println(account);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return account;
	}
}
