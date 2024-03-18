package org.iclass.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Notice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

public class NoticeWriteSaveController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NoticeWriteSaveController.class);


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//서버에 전송될 위치(파일시스템 경로)
		String path = "D:\\Class231228\\upload";
		
		//업로드 가능한 최대 크기(바이트)
		int maxSize = 30*1024*1024;		//1024바이트=1KB, 30MByte로 설정
		
		//request 를 파일을 받을 수 있는 request로 사용해야 합니다. : cos 라이브러리 추가
		MultipartRequest multiRequest = new MultipartRequest(request, 
				path,
				maxSize,
				"UTF-8",
				new DateFileRenamePolicy());		
		//DefaultFileRenamePolicy는 중복된 파일명에 대해 새로파일명 부여하는 규칙(파일명뒤에 일련번호)
		
		String attachfile = multiRequest.getOriginalFileName("attachfile");
		//서버로 업로드된 파일의 파일명
		String filename = multiRequest.getFilesystemName("attachfile");
		logger.info("::: 파일명-{} from {}  :::",filename,attachfile);   //uploadFile
		//서버의 파일 시스템 D:\\Class231228\\upload 경로에서 파일이 생겼는지 확인하기
		
		
		String title=multiRequest.getParameter("title");
		String content=multiRequest.getParameter("content");
		
		Notice vo = Notice.builder()
				.title(title)
				.content(content)
				.attachFile(attachfile)
				.uploadFile(filename)
				.build();
		
		NoticeDao dao = NoticeDao.getInstance();
		long result = dao.write(vo);
		if(result!=0) {
			response.sendRedirect("list");
		}else {
			//메인화면으로 이동
			response.sendRedirect(request.getContextPath());
		}
	}

}


