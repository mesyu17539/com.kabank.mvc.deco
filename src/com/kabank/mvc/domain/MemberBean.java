package com.kabank.mvc.domain;

import lombok.Data;

@Data
public class MemberBean {
	//어소시에이션 방식
	private String id, pass, name,ssn,phone, email,profile,addr;
	private AccountBean account;
	@Override
	public String toString() {
		return account==null? 
			"회원정보 [ID : " + id + ", 비밀번호 :" + pass + ", 이름 : " + name + ", 주민번호(생년월일-첫번째 번호) " + ssn + ", 전화번호 : " + phone
					+ ", 이메일 : " + email + ", 프로필사진 : " + profile + ", 주소 : " + addr + "]\n"
				:
			"회원정보 [ID : " + id + ", 비밀번호 :" + pass + ", 이름 : " + name + ", 주민번호(생년월일-첫번째 번호) " + ssn + ", 전화번호 : " + phone
					+ ", 이메일 : " + email + ", 프로필사진 : " + profile + ", 주소 : " + addr + ",계좌번호["+account.getAccountNum()+"]]\n";
	}
}
