package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMembers(String id,String pass);
	public void memberJoin(MemberBean bean);
	public MemberBean selectMemberById();
	public void chagePass();
	public void deleteMember();
	public void memJoin();
}
