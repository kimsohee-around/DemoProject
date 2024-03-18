package org.iclass.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.vo.DemoMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebFilter(servletNames = { "FrontController" })
public class SessionFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//로그인이 되었을 때 접근할 수 없는 url 입니다.
		List<String> nosessions = List.of("/member/join","/login","/test");
		//로그인을 해야 접근할 수 있는 url 입니다.
		List<String> logins = List.of("/community/update","/community/delete",
						"/community/comments","/community/write","/member/modify","/member/drop","/api/modify");
		//List.of 메소드는 java 9 부터 사용합니다. 불변컬렉션(추가/삭제 못하는 리스트) 생성
		
		//관리자만 접근하는 url
		List<String> admins = List.of("/notice/write","/notice/update","/notice/delete","/admin");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		logger.info(":::::::: 요청 전 SessionFilter: {} ::::::::",httpRequest.getServletPath());
		HttpSession session = httpRequest.getSession();
		DemoMember user = (DemoMember) session.getAttribute("user");
//로그인이 되었을 때(user != null ) 접근할 수 없는 url 입니다.   또는  //로그인 안됐을때(user == null) 접근할 수 없는 url 입니다.
		if(nosessions.contains(httpRequest.getServletPath()) && user != null 
				|| logins.contains(httpRequest.getServletPath()) && user == null) {
			//접근이 안되는 경우 컨텍스트 패스로 redirect
			httpResponse.sendRedirect(httpRequest.getContextPath());
			return;		//다음 필터 적용하지 않도록 종료
		}
		
		if(admins.contains(httpRequest.getServletPath()) && 
				(user==null || !user.getUserid().equals("admin"))) { 		//로그인은 안헀거나 id가 'admin'이 아니면
			//httpResponse.sendRedirect(httpRequest.getContextPath());
				throw new IOException();
//			return;	
		}
		
		chain.doFilter(request, response);
		logger.info(":::::::: 요청 후  SessionFilter: {} ::::::::",httpRequest.getServletPath());
	}

}
