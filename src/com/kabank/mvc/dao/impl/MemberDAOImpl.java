package com.kabank.mvc.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.SearchSessionCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.decorate.ExcuteQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLENUM;
import com.kabank.mvc.enums.TNameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.query.member.DeleteMemberQuery;
import com.kabank.mvc.query.member.LoginQuery;
import com.kabank.mvc.util.Enums;
import com.kabank.mvc.util.MemberEnum;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}
	private MemberDAOImpl() {//Thread single패턴
	/*	try {
			Class.forName(DBMS.ORACLE_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
/*	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	private MemberDAOImpl() {}
*/	List<MemberBean> list;
	Connection conn;
	Statement stat;
	ResultSet sel;
	@Override
	public List<MemberBean> selectMembers(String id, String pass) {
		list=new ArrayList<>();
		MemberBean member = null;
		try {
			/*new StringBuffer(DMLENUM.SELECT.toString())
			.insert(7, Enums.getEnu().toString())
			+Enums.TABLE.MEMBER.toString()*/
			System.out.println("=====SlectById IN==============");
			sel=DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(
							new StringBuffer(DMLENUM.SELECT.toString())
							.insert(7, Enums.getEnu().toString())
							+Enums.TABLE.MEMBER.toString()
							/*SqlFactory.create(6,DMLENUM.SELECT.toString()+Enums.getEnu().toString()+Enums.TABLE.MEMBER.toString())*/)
					;
			/*list=new ArrayList<>();
			try {
				sel=DatabaseFactory.createDatabase(Vendor.ORACLE)
						.getConnection()
						.createStatement()
						.executeQuery(new StringBuffer(DMLENUM.SELECT.toString()).insert(7, Enums.getEnu().toString())
								+Enums.TABLE.MEMBER.toString())
						;*/
			/*SELECT id, pass, name,ssn,phone, 
			 * email,profile,addr FROM MEMBER*/
/*			sel=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD)
					.createStatement()
					.executeQuery(MemberSQL.MEMBERS)
					;*/			
			
			while(sel.next()) {
				member=new MemberBean();
				member.setId(sel.getString("ID"));
				member.setPass(sel.getString("PASS"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====ID : "+member.getId());
		System.out.println("=====pass : "+member.getPass());
		System.out.println("============Select OUT=============");
		System.out.println(list);
		return list;
	}

	@Override
	public void memberJoin(MemberBean bean) {
		System.out.println("쿼리문 진입");
		try {
			DatabaseFactory.create(Vendor.ORACLE)
				.getConnection()
				.createStatement()
				.executeUpdate(String.format("%s %s %s("
					+Enums.getEnu()+")"
					+ " VALUES("
					+Enums.getBlanks(Enums.MemberCalum.values().length)
					+")",
					Enums.DML.INSERT,
					Enums.DML.INTO,
					Enums.TABLE.MEMBER,
					bean.getId(),
					bean.getPass(),
					bean.getName(),
					bean.getSsn(),
					bean.getPhone(),
					bean.getEmail(),
					bean.getProfile(),
					bean.getAddr()
					));
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*try {
			DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD)
			.createStatement()
			.executeQuery((String.format("%s %s %s("
						+Enums.getEnu()+")"
						+ " VALUES("
						+Enums.getBlanks(Enums.MemberCalum.values().length)
						+")",
						Enums.DML.INSERT,
						Enums.DML.INTO,
						Enums.TABLE.MEMBER,
						bean.getId(),
						bean.getPass(),
						bean.getName(),
						bean.getSsn(),
						bean.getPhone(),
						bean.getEmail(),
						bean.getProfile(),
						bean.getAddr()
						));
			}catch(Exception e) {
				e.printStackTrace();
			}*/
	}

	public MemberBean selectMemberById() {
		System.out.println("DAOIMPL 진입");
		MemberBean bea=null;
		try {
			ResultSet rs=DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(
					String.format(new StringBuffer(DMLENUM.SELECT.toString()).insert(7, Enums.getEnu().toString())
							+Enums.TABLE.MEMBER.toString()
							+DMLENUM.WHERE.toString()
							,InitCommand.cmd.getData().split("/")[0],InitCommand.cmd.getData().split("/")[1]));
			while(rs.next()) {
				bea=new MemberBean();
				System.out.println("id 받은 값 : "+rs.getString("id"));
				System.out.println("pass 받은 값 : "+rs.getString("pass"));
				bea.setId(rs.getString("id"));
				bea.setPass(rs.getString("pass"));
				bea.setName(rs.getString("name"));
				bea.setSsn(rs.getString("ssn"));
				bea.setPhone(rs.getString("phone"));
				bea.setEmail(rs.getString("email"));
				bea.setProfile(rs.getString("profile"));
				bea.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bea;
	}
/*	public MemberBean selectMemberById(MemberBean bean) {
		System.out.println("DAOIMPL 진입");
		MemberBean bea=null;
		try {
			ResultSet rs=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM MEMBER where id= '%s' AND pass='%s'",bean.getId(),bean.getPass()));
			while(rs.next()) {
				bea=new MemberBean();
				System.out.println("id 받은 값 : "+rs.getString("id"));
				System.out.println("pass 받은 값 : "+rs.getString("pass"));
				bea.setId(rs.getString("id"));
				bea.setPass(rs.getString("pass"));
				bea.setName(rs.getString("name"));
				bea.setSsn(rs.getString("ssn"));
				bea.setPhone(rs.getString("phone"));
				bea.setEmail(rs.getString("email"));
				bea.setProfile(rs.getString("profile"));
				bea.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bea;
	}
*//*	public MemberBean selectMemberById(MemberBean bean) {
		System.out.println("DAOIMPL 진입");
		MemberBean bea=null;
		String sql="SELECT * FROM MEMBER WHERE id=? AND pass=?";
		try {
			PreparedStatement pstat=DriverManager.getConnection(
					DBMS.ORACLE_CONECTIONURL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD).prepareStatement(sql);
			pstat.setString(1, bean.getId());
			pstat.setString(2, bean.getPass());
			ResultSet rs=pstat.executeQuery();
			while(rs.next()) {
				bea=new MemberBean();
				System.out.println("id 받은 값 : "+rs.getString("id"));
				System.out.println("pass 받은 값 : "+rs.getString("pass"));
				bea.setId(rs.getString("id"));
				bea.setPass(rs.getString("pass"));
				bea.setName(rs.getString("name"));
				bea.setSsn(rs.getString("ssn"));
				bea.setPhone(rs.getString("phone"));
				bea.setEmail(rs.getString("email"));
				bea.setProfile(rs.getString("profile"));
				bea.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bea;
	}
*/
	@Override
	public void chagePass() {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer(MemberEnum.CHANGEPASS.toString());
		String[] arr=InitCommand.cmd.getData().split("/");
		System.out.println("DAO\nid : "+arr[0]);
		System.out.println("pass : "+arr[1]);
		System.out.println("newpass : "+arr[2]);
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, arr[2]);
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, arr[0]);
		sql.replace(sql.indexOf("&"), sql.indexOf("&")+1, arr[1]);
		System.out.printf(
		/*"내가 실행하려는 sQL : "+DMLENUM.UPDATE.toString()
		+Enums.TABLE.MEMBER.toString()
		+DMLENUM.SET.toString()+"\n"
		,bean.getPass(),bean.getId()*/
				sql.toString()
		);
		try {
			DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeUpdate(sql.toString());
					/*(String.format(DMLENUM.UPDATE.toString()
						+Enums.TABLE.MEMBER.toString()
						+DMLENUM.SET.toString()
						,bean.getPass(),bean.getId()));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMember() {
		// TODO Auto-generated method stub
		System.out.println("딜리트 쿼리 결과 : "+new ExcuteQuery(new DeleteMemberQuery()).execute());
		/*StringBuffer sql=new StringBuffer(MemberEnum.MEMBERDELETE.toString());
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1,InitCommand.cmd.getData().split("/")[0]);
		System.out.println("dele sql"+sql.toString());
		try {
			DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeUpdate(sql.toString());
					(String.format(DMLENUM.UPDATE.toString()
						+Enums.TABLE.MEMBER.toString()
						+DMLENUM.SET.toString()
						,bean.getPass(),bean.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	@Override
	public void memJoin() {
		// TODO Auto-generated method stub
		try {
			DatabaseFactory.create(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeUpdate(
			String.format(
				MemberEnum.MEMJOIN.toString()
						,Enums.TABLE.MEMBER
						,InitCommand.cmd.getColum()
						,InitCommand.cmd.getData()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		String[] arr=InitCommand.cmd.getData().split("/");
		try {
			DatabaseFactory.create(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeUpdate(
					String.format(
							String.format(MemberEnum.MEMJOIN.toString()
									,Enums.TABLE.MEMBER
									,Enums.getEnu()
									,Enums.getBlanks(Enums.MemberCalum.values().length))
							,arr[0],arr[1],arr[2],arr[3]
									,arr[4],arr[5],arr[6],arr[7]));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/	}
}
