package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMembers(String id,String pass);
	public void memberJoin(MemberBean bean);
	public MemberBean selectMemberById(MemberBean bean);
	public MemberBean login();
	public void chagePass(MemberBean bean);
	public void deleteMember();
	public void memJoin();
}
