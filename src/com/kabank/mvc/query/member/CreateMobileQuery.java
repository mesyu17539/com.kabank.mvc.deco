package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.TelecomProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.util.Enums.DML;
import com.kabank.mvc.util.Enums.TABLE;

public class CreateMobileQuery implements IQuery{
	PreparedStatement pstmt;
	public CreateMobileQuery() {
		System.out.println("create 모바일 쿼리");
		try {
			pstmt=DatabaseFactory.create(Vendor.ORACLE)
			.getConnection().prepareStatement(
					DML.INSERT
					+" "
					+DML.INTO
					+" "
					+TABLE.MOBILE
					+"("
					+InitCommand.cmd.getColum()
					+") "
					+DML.VALUES
					+"("
					+InitCommand.cmd.getData()
					+")");
			System.out.println("쿼리문 "+
					DML.INSERT
					+" "
					+DML.INTO
					+" "
					+TABLE.MOBILE
					+"("
					+InitCommand.cmd.getColum()
					+") "
					+DML.VALUES
					+"("
					+InitCommand.cmd.getData()
					+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("로그인 쿼리 out");
	}

	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		String foo="0";
		try {
			foo=String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foo;
	}
	
}
