package org.iclass.controller.notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;

public class NoticeFileDownloadController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  // 다운로드할 파일 경로 설정
	    String filePath = "D:\\Class231228\\upload";

	    // 다운로드할 파일명 설정
	    String fileName = request.getParameter("uploadfile");
	    String originfile = request.getParameter("attachfile");
	    if(fileName==null) throw new RuntimeException();

	    // 파일 객체 생성
	    File file = new File(filePath,fileName);
	    int fileSize = (int) file.length();
	    
	    if(fileSize==0) throw new RuntimeException();
	    
	    // 다운로드할 파일의 MIME 타입 설정
	    response.setContentType("application/octet-stream;");
	    response.setContentLength(fileSize);
	    response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(originfile, "ISO8859-1"));
	    response.setContentLengthLong(fileSize);
	    
	    // 파일 입력 스트림 생성
	    FileInputStream in = new FileInputStream(file);
	    OutputStream out = response.getOutputStream();

	    // 파일 전송
	    byte[] buffer = new byte[4096];
	    int bytesRead = -1;
	    while ((bytesRead = in.read(buffer)) != -1) {
	        out.write(buffer, 0, bytesRead);
	    }

	    // 자원 해제
	    in.close();
	    out.close();
		

	}

}
