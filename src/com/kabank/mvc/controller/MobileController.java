package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.CreatMoCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceImpl.MobileServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet("/mobile.do")
public class MobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("============모바일 컨트롤러 진입=============");
		HttpSession session=request.getSession();
		MemberBean mrg;
		new InitCommand(request).execute();
		switch(InitCommand.cmd.getAction()) {
		case CREATEMOBILE:
			new CreatMoCommand(request).execute();
			MobileServiceImpl.getInstance().create();
			new MoveCommand(request).execute();
			mrg=(MemberBean)session.getAttribute("user");
			mrg.setMobile(MobileServiceImpl.getInstance().selectMobile());
			session.setAttribute("user", mrg);
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
		
		}
	}
}
