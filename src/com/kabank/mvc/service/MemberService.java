package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public abstract MemberBean findById(MemberBean bean);//디폴트이며 생략가능한 이유는 다른건 못오기 때문이다
	public void join(MemberBean bean);
	public MemberBean login();
	public void chage(MemberBean m);
	public void leave();
	public void memjoin();
}
