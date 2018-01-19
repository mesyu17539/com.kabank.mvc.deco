package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.service.LottoService;

public class LottoServiceImpl implements LottoService{
	public static LottoServiceImpl getInstance() {
		return new LottoServiceImpl();
	}
	private LottoServiceImpl() {}
}
