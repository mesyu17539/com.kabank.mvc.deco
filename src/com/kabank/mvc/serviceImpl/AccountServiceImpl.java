package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.service.AccountService;

public class AccountServiceImpl implements AccountService{
	public static AccountServiceImpl getInstance() {
		return new AccountServiceImpl();
	}
	public AccountServiceImpl() {}
}
