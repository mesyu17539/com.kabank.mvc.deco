package com.kabank.mvc.serviceImpl;

import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.dao.impl.MemberDAOImpl;
import com.kabank.mvc.dao.impl.MobileDAOImpl;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.TelecomBean;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {}
	@Override
	public MemberBean login() {
		System.out.println("ServiceIMPL 진입");
		MemberBean mbean=MemberDAOImpl.getInstance().selectMemberById();
		AccountBean abean=AccountServiceImpl.getInstance().selectAccount();
		TelecomBean tbean=MobileServiceImpl.getInstance().selectMobile();
		System.out.printf("맴\n"+mbean+""
				+ "\n계\n"+abean+"\n텔"+tbean);
		if(mbean!=null) {
			if(abean!=null) {
				System.out.println("계좌있다");
				mbean.setAccount(abean);
			}
			if(tbean!=null) {
				System.out.println("폰있다");
				mbean.setMobile(tbean);
			}
		}
		/*Object[] objects= {MemberDAOImpl.getInstance().selectMemberById(),AccountServiceImpl.getInstance().selectAccount(),MobileServiceImpl.getInstance().selectMobile()};
		if(objects[0]!=null) {
			if(objects[1]!=null) {
				System.out.println("계좌있다");
			}
			if(objects[2]!=null) {
				System.out.println("폰있다");
			}
		}*/
		System.out.println("리턴시킬 빈"+mbean);
		return mbean;
		
		/*for(int i=0;i<mbean.size();i++) {
			if(bean.getId().equals(mbean.get(i).getId())) {
				if(bean.getPass().equals(mbean.get(i).getPass()))
					bool=true;
					bea=mbean.get(i);
			}
		}*/
/*		List<MemberBean> mbean=new MemberDAOImpl().selectMembers(id,pass);
		for(int i=0;i<mbean.size();i++) {
			if(id.equals(mbean.get(i).getId())) {
				if(pass.equals(mbean.get(i).getPass()))
				bool=true;
			}
		}*/		
	}

	@Override
	public void join(MemberBean bean) {
		System.out.println("서비스impl :\n"+bean);
		 MemberDAOImpl.getInstance().memberJoin(bean);
	}
	@Override
	public void chage() {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().chagePass();
	}
	@Override
	public void leave() {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().deleteMember();
	}
	@Override
	public void memjoin() {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().memJoin();
	}

}
