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
