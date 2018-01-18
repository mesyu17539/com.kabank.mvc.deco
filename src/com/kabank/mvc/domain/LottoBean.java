package com.kabank.mvc.domain;

import lombok.Data;

@Data
public class LottoBean {
	private String lottoNum;

	@Override
	public String toString() {
		return "당신의 로또타임 [번호 : " + lottoNum + "]";
	}
}
