package org.iclass.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notice {
	private long idx;
	private String title;
	private String content;
	private int readCount;
	private Timestamp createdAt;
	private String attachFile;
	private String uploadFile;

}
/*
	Builder 애노테이션은 빌더패턴이라는 형식으로 객체 생성과 초기화를 합니다.
	- 생성자로 객체 생성과 모든 프로퍼티 변수를 초기화 하였던 형식을 대신하여
	- 객체 생성 메소드와 각각의 프로퍼티 변수를 초기화 하는 메소드가 정의되어 있습니다.
	- NoticeWriteSaveController 의 49번 라인에서 활용하였습니다.
*/