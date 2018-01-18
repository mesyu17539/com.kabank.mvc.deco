package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.command.ACountcreateCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.serviceImpl.KakaoServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet("/kakao.do")
public class KakaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========카카오 서블릿 내부=========");
		new InitCommand(request).execute();
		System.out.println("switch문 Action"+InitCommand.cmd.getAction());
		switch(InitCommand.cmd.getAction()) {
		case MOVE:
			move(request, response);
			break;
		case CREATEANUM:
			System.out.println("========Kakao : MOVE=========");
			new ACountcreateCommand(request).execute();
			KakaoServiceImpl.getInstance().createACNUM();
			new MoveCommand(request).execute();
			System.out.println("========Kakao : MOVE OUT=========\n"+InitCommand.cmd.getView());
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
		}
	}

	private void move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========Kakao : MOVE=========");
		new MoveCommand(request).execute();
		System.out.println("========Kakao : MOVE OUT=========\n"+InitCommand.cmd.getView());
		DispatcherServlet.send(request, response);
	}

}
