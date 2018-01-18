package com.kabank.mvc.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.enums.DDLENUM;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void createMembers(String tname) {
		String str="";
		try {
			if(tname.equalsIgnoreCase("ATTEND")) {
				str=DDLENUM.CREATE_TABLE_ATTEND.toString();
			}else if(tname.equalsIgnoreCase("BANK")) {
				DatabaseFactory.create(Vendor.ORACLE)
				.getConnection()
				.createStatement()
				.executeUpdate(DDLENUM.CREATE_TABLE_RULE.toString());
				str=DDLENUM.CREATE_TABLE_BANK.toString();
			}else if(tname.equalsIgnoreCase("MEMBER")) {
				str=DDLENUM.CREATE_TABLE_MEMBER.toString();
			}else if(tname.equalsIgnoreCase("TELECOM")) {
			str=DDLENUM.CREATE_TABLE_TELECOM.toString();
		}
			
			DatabaseFactory.create(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeUpdate(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> selectTable() {
		List<String> list=new ArrayList<>();
		try {
			ResultSet set=DatabaseFactory.create(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeQuery("SELECT * FROM tab");
			while(set.next()) {
				list.add(set.getString("TNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
