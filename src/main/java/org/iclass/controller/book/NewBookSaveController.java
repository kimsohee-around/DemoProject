package org.iclass.controller.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.DemoMemberDao;
import org.iclass.dao.NewBooksDao;
import org.iclass.vo.NewBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NewBookSaveController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NewBookSaveController.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에 전송될 위치(파일시스템 경로)
		String path = "C:\\upload";
		
		//업로드 가능한 최대 크기(바이트)
		int maxSize = 10*1024*1024;		//1024바이트=1KB, 10MByte로 설정
		
		//request 를 파일을 받을 수 있는 request로 사용해야 합니다. : cos 라이브러리 추가
		MultipartRequest multiRequest = new MultipartRequest(request, 
				path,
				maxSize,
				"UTF-8",
				new DefaultFileRenamePolicy());		
		//DefaultFileRenamePolicy는 중복된 파일명에 대해 새로파일명 부여하는 규칙(파일명뒤에 일련번호)
		
		//기존 방식처럼 text 타입 등 파라미터 받아오기
		String title = multiRequest.getParameter("title");
		String temp = multiRequest.getParameter("summary");
		String userid = multiRequest.getParameter("userid");
		
		//서버로 업로드된 파일의 파일명
		String cover = multiRequest.getFilesystemName("coverfile");
		logger.info("::: 파일명-{}  :::",cover);   //uploadFile
		//서버의 파일 시스템 C:\\upload 경로에서 파일이 생겼는지 확인하기
		
		//dao의 insert 실행하세요.
		NewBooksDao dao = NewBooksDao.getInstance();
		String url=null;
		//Clob summary = NewBooksDao.clobConvert(temp);
		NewBooks book =  new NewBooks(0, title, temp, null, cover, userid);
		
		if(dao.insert(book)==1) {
			url="list";
		}else {
			url="new";
		}
		response.sendRedirect(url);
	}

}
