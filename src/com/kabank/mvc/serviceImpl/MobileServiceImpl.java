package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.impl.MobileDAOImpl;
import com.kabank.mvc.domain.TelecomBean;
import com.kabank.mvc.service.MobileService;

public class MobileServiceImpl implements MobileService{
	public static MobileServiceImpl getInstance() {
		return new MobileServiceImpl();
	}
	private MobileServiceImpl() {}
	@Override
	public String create() {
		return MobileDAOImpl.getInstance().joinMobile();
	}
	@Override
	public TelecomBean selectMobile() {
		return MobileDAOImpl.getInstance().selectMobile();
	}
	
}
