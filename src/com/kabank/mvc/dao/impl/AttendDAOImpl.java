package com.kabank.mvc.dao.impl;

import com.kabank.mvc.dao.AttendDAO;

public class AttendDAOImpl implements AttendDAO{
	public static AttendDAOImpl getInstance() {
		return new AttendDAOImpl();
	}
	private AttendDAOImpl() {}
}
