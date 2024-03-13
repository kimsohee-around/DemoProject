package org.iclass.controller.api;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class ApiNewBookImageUploadController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(ApiNewBookImageUploadController.class);
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
				new DateFileRenamePolicy());		
		//DefaultFileRenamePolicy 대신에 현재시간으로 파일명 변경
		
		//서버로 업로드된 파일의 파일명
		String filename = multiRequest.getFilesystemName("uploadFile");
		logger.info("::: 파일명-{}  :::",filename);   //uploadFile
		//서버의 파일 시스템 C:\\upload 경로에서 파일이 생겼는지 확인하기
		
		ObjectMapper objmapper = new ObjectMapper();
		Map<String,String> data = new HashMap<>();
		data.put("filename", filename);
		String jsonData = objmapper.writeValueAsString(data);
		
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
	}

}

class DateFileRenamePolicy implements FileRenamePolicy {

    @Override
    public File rename(File file) {
        String parentDir = file.getParent();
        String fileName = file.getName();

        // 현재시간으로 새로운 파일명 생성
        String newFileName = String.valueOf(new Date().getTime());
        
        // 파일명과 확장자 분리
        int dotIndex = fileName.lastIndexOf(".");
        String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex);

        newFileName = newFileName + extension;
      
        // 새로운 파일 객체 생성
        File newFile = new File(parentDir, newFileName);

        // 중복된 파일이 존재하는 경우, 재귀 호출을 통해 새로운 파일명 생성
        if (newFile.exists()) {
            return rename(file);
        }

        // 새로운 파일 객체 반환
        return newFile;
    }
}
