package org.iclass.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Notice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeReadController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NoticeReadController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = request.getParameter("idx");			//메인글 글번호 파라미터로 받기
		int idx=0;
		try {
			idx = Integer.parseInt(temp);

			NoticeDao dao = NoticeDao.getInstance();
			//조회수 증가 : 실행 위치는?
			//dao.setReadCount(idx);
			
			Notice vo = dao.read(idx);
			if(vo==null) throw new RuntimeException();   //잘못된 파라미터로 vo가 null 일때 런타임예외 발생시키기
			logger.debug("::::::: vo-{}:::::::",vo);
			request.setAttribute("vo", vo);
			
			//현재페이지를 list.jsp에서 받아서 read.jsp로 전달합니다.-> paging 값들을 세션애트리뷰트에 저장된 상태입니다.
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("read.jsp");
			dispatcher.forward(request, response);
		}catch (NumberFormatException  e) {
			response.sendRedirect("list");			// NumberFormatException  처리
		}

	}

}
