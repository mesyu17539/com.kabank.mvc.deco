package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		System.out.println("cmd action: "+x);
		if(x==null){x="move";}
		switch (x) {
		case "move":
			action=Action.MOVE;break;
		case "login":
			action=Action.LOGIN;break;
		case "memberjoin":
			action=Action.MEMJOIN;break;
		case "change":
			action=Action.CHANGE;break;
		case "leave":
			action=Action.LEAVE;break;
		case "createanum":
			action=Action.CREATEANUM;break;
		case "TELECOM":
			action=Action.TELECOM;break;
		case "join":
			action=Action.CREATEMOBILE;break;
		default:
			action=Action.MOVE;break;
		}
		System.out.println("Action 값 입력 : "+action.toString());
		return action;
	}
}
