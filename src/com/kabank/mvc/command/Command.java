package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

import lombok.Data;

@Data
public class Command{
	protected String cmd, dir, page, view, data, colum;//colum:DB의 metadata
	protected Action action;
}
