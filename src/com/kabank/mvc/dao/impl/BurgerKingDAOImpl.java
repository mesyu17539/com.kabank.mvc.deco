package com.kabank.mvc.dao.impl;

import com.kabank.mvc.dao.BurgurKingDAO;

public class BurgerKingDAOImpl implements BurgurKingDAO{
	public static BurgerKingDAOImpl getInstance() {
		return new BurgerKingDAOImpl();
	}
	private BurgerKingDAOImpl() {}
}
