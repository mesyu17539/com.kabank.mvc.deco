package com.kabank.mvc.decorate;

public class ExcuteQuery extends QueryDecorator{
	//추상클래스를 쓰는 이유는 상속과 강제성을 갖게 하기 위해서이다.

	public ExcuteQuery(IQuery query) {
		super(query);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
