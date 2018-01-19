package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.impl.AccountDAOImpl;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.service.AccountService;

public class AccountServiceImpl implements AccountService{
	public static AccountServiceImpl getInstance() {
		return new AccountServiceImpl();
	}
	public AccountServiceImpl() {}
	public AccountBean selectAccount() {
		return AccountDAOImpl.getInstance().selectAccountByID();
	}
}
