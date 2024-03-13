package org.iclass.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.vo.DemoMember;

public class NoticeWriteController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DemoMember user = (DemoMember) session.getAttribute("user");
		
		//admin 계정만 write 권한이 있습니다. 권한 확인!!
		if(user==null || !user.getUserid().equals("admin")) throw new RuntimeException();
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("write.jsp");
		dispatcher.forward(request, response);
	}

}
