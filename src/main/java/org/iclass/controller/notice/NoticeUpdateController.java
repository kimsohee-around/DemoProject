package org.iclass.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Community;
import org.iclass.vo.DemoMember;
import org.iclass.vo.Notice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeUpdateController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NoticeUpdateController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정 화면으로 데이터 보내기 구현해 보세요.
		//지정된 idx 메인글 가져오기
				String temp = request.getParameter("idx");			//메인글 글번호 파라미터로 받기
				int idx=0;
				HttpSession session = request.getSession();
				DemoMember user = (DemoMember) session.getAttribute("user");
				try {
					idx = Integer.parseInt(temp);
					NoticeDao dao = NoticeDao.getInstance();
					Notice vo = dao.read(idx);
					
					if(vo==null || !user.getUserid().equals("admin")) throw new RuntimeException();
					request.setAttribute("vo", vo);				
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
					dispatcher.forward(request, response);
				}catch (NumberFormatException e) {
					response.sendRedirect("list");
				}
						

	}

}
