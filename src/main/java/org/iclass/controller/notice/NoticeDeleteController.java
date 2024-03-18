package org.iclass.controller.notice;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeDeleteController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NoticeDeleteController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String temp=request.getParameter("idx");
		int idx = Integer.parseInt(temp);
		
		NoticeDao dao = NoticeDao.getInstance();
		int result = dao.delete(idx);
		
		HttpSession session = request.getSession();
		Paging paging = (Paging) session.getAttribute("paging");
		
		if(result!=0) {
			String url = "list?idx="+idx + "&page="+paging.getCurrentPage();
			
			if(paging.getFindText() !=null) {
			  String findText= URLEncoder.encode(paging.getFindText(), "UTF-8");
			  String column=paging.getColumn(); 
			  url +="&findText="+findText + "&column="+column; 
			 }
			 
			response.sendRedirect(url);
		}else {
			//메인화면으로 이동
			response.sendRedirect(request.getContextPath());
		}

	}

}
