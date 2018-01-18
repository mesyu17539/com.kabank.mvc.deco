package com.kabank.mvc.domain;

import lombok.Data;

@Data
public class AttendBean {
	private String id, name, attend;
	
	@Override
	public String toString() {
		return "출결정보 [id=" + id + ", 이름=" + name + ", 출결 상태=" + attend + "]";
	}
}
