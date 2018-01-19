package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.util.Enums.DML;
import com.kabank.mvc.util.Enums.TABLE;

public class DeleteMemberQuery implements IQuery{
	PreparedStatement pstmt;
	public DeleteMemberQuery() {
		System.out.println("삭제맴버 쿼리");
		try {
			pstmt=DatabaseFactory.create(Vendor.ORACLE)
			.getConnection().prepareStatement(
					DML.DELETE
					+" "
					+DML.FROM
					+" "
					+TABLE.MEMBER
					+" "
					+DML.WHERE
					+" id LIKE ? AND pass LIKE ?");
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i = 0; i < arr.length; i++) {
				System.out.println("for"+arr[i]);
				pstmt.setString((i+1), arr[i]);
			}
			System.out.println("쿼리문 조합 데이터 "+
					DML.DELETE
					+" "
					+DML.FROM
					+" "
					+TABLE.MEMBER
					+" "
					+DML.WHERE
					+" id LIKE "+arr[0]+" AND pass LIKE "+arr[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		String foo="";
		try {
			foo=String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foo;
	}
	
}
