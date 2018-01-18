package com.kabank.mvc.decorate;

public class QueryDecorator implements IQuery{
	protected IQuery query;
	public QueryDecorator(IQuery query) {
		this.query=query;
	}
	@Override
	public Object execute() {
		return query.execute();
	}
	
}
