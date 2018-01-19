package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.service.BurgerkingService;

public class BurgerkingServiceImpl implements BurgerkingService{
	public static BurgerkingServiceImpl getInstance() {
		return new BurgerkingServiceImpl();
	}
	public BurgerkingServiceImpl() {}
}
