package org.iclass.controller.notice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeListController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NoticeListController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		logger.info(":::::::: 요청 {} 처리 시작 : {} ::::::::",this.getClass(),request.getServletPath());
		int currentPage = 1;		//현재 페이지 초기값
		NoticeDao dao = NoticeDao.getInstance();

		String page=request.getParameter("page");
		if(page != null) currentPage = Integer.parseInt(page);		
		int pageSize=7;		
		int totalCount =0;
		//검색을 위해 추가된 값
		String findText = request.getParameter("findText");  //검색 단어
		String column = request.getParameter("column");		//검색 컬럼
		if(column!=null && (column.equals("none") || column.length()==0))
				column=null;
		
		Map<String, String> findMap = null;
		if(findText!=null) {   //새로운 검색값으로 검색 버튼을 클릭했을 때
			findMap = new HashMap<String, String>();
			findMap.put("findText", findText);
			findMap.put("column", column);
			
		}
		totalCount = dao.count(findMap);
		
		//위의 값들을 이용해서 Paging 객체를 생성하면서 다른 필드값을 계산합니다.
		Paging paging = new Paging(currentPage, totalCount, pageSize);
		logger.info(":::::::: ListController paging : {} ::::::::",paging);
		paging.setFind(findMap);
		
		//list 구할 메소드 실행하고 애트리뷰트 저장합니다.
		request.setAttribute("list", dao.list(paging));
		
		//페이지 목록을 화면구현하기 위한 애트리뷰트(객체)를 저장합니다.페이지번호,검색어,검색컬럼 등등 
		//url에 검색파라미터를 계속 유지해야하므로 이 객체 정보 저장을 세션 애트리뷰트를 사용해 봅니다.
		HttpSession session = request.getSession();
		session.setAttribute("paging", paging);
		
		//현재날짜시간 저장-출력형식 2개 중 하나 고를때 비교값
		request.setAttribute("today", LocalDate.now());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);

	}

}
