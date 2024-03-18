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

public class NoticeUpdateSaveController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NoticeUpdateSaveController.class);

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
		
		String attachfile = multiRequest.getOriginalFileName("attachfile");
		//서버로 업로드된 파일의 파일명
		String filename = multiRequest.getFilesystemName("attachfile");
		logger.info("::: 파일명-{} from {}  :::",filename,attachfile);   //uploadFile
		//서버의 파일 시스템 D:\\Class231228\\upload 경로에서 파일이 생겼는지 확인하기
		
		
		String temp=multiRequest.getParameter("idx");
		int idx = Integer.parseInt(temp);
		String title=multiRequest.getParameter("title");
		String content=multiRequest.getParameter("content");
		
		String uploadFile = multiRequest.getParameter("uploadFile");
		if(uploadFile !=null) {		//첨부된 파일을 수정하지 않은 경우
			filename=uploadFile;
			attachfile=multiRequest.getParameter("attachFile");
		}
		Notice vo = Notice.builder()
				.idx(idx)
				.title(title)
				.content(content)
				.attachFile(attachfile)
				.uploadFile(filename)
				.build();
		
		NoticeDao dao = NoticeDao.getInstance();
		long result = dao.update(vo);
		
		if(result!=0) {
			String url = "read?idx="+idx;
			/*
			 * if(request.getParameter("findText")!=null) {
			 * findText=request.getParameter("findText");
			 * column=request.getParameter("column"); url +="&findText="+findText +
			 * "&column="+column; }
			 */
			response.sendRedirect(url);
		}else {
			//메인화면으로 이동
			response.sendRedirect(request.getContextPath());
		}

	}

}
