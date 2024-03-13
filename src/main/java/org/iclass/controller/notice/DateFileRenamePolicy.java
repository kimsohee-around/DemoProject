package org.iclass.controller.notice;

import java.io.File;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class DateFileRenamePolicy implements FileRenamePolicy {

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