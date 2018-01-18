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
					+"b.customer_Num as customer_Num," + 
					"m.id as id," + 
					"m.pass as pass," + 
					"m.name as name," + 
					"m.phone as phone," + 
					"m.email as email," + 
					"m.profile as profile," + 
					"m.addr as addr," + 
					"b.account_Num as account_Num," + 
					"b.money as money "
					+" "
					+DML.FROM
					+" "
					+TABLE.MEMBER+" m,"+TABLE.BANK+" b"
					+" "
					+DML.WHERE
					+" m.id LIKE ? AND m.pass LIKE ?");
			System.out.println("이닛 데이터"+InitCommand.cmd.getData());
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i = 0; i < arr.length; i++) {
				System.out.println("for"+arr[i]);
				pstmt.setString((i+1), arr[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("로그인 쿼리 out");
	}
	@Override
	public Object execute() {
		MemberBean member=null;
		AccountBean account=null;
		try {
			System.out.println("===MEMBER.D: LOGIN IN===");
			/*System.out.println("로그인 쿼리 createStatement\n::SQL::"+sql.toString());*/
			/*ResultSet rs=DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeQuery(sql.toString())*/
			ResultSet rs=pstmt.executeQuery();	
			while(rs.next()) {
				System.out.println("while");
				member =new MemberBean();
				account =new AccountBean();
				member.setId(rs.getString(MemberEnum.ID.toString()));
				System.out.println("id"+member.getId());
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				member.setName(rs.getString(MemberEnum.NAME.toString()));
				member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				member.setAddr(rs.getString(MemberEnum.ADDR.toString()));
				member.setPhone("T");
				member.setProfile("T");
				member.setSsn("T");
/*				member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
				member.setSsn(rs.getString(MemberEnum.SSN.toString()));
*/				account.setAccountNum(rs.getString(AccountProps.ACCOUNT_NUM.toString()));
				account.setCustomerNum(rs.getString(AccountProps.CUSTOMER_NUM.toString()));
				account.setMoney(rs.getString(AccountProps.MONEY.toString()));
				System.out.println(account);
				member.setAccount(account);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return member;
	}
}
