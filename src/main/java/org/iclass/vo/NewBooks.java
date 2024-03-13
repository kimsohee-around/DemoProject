package org.iclass.vo;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewBooks {
	private int idx;
	private String title;
	
//	@JsonSerialize(using = ClobSerializer.class)
//	@JsonDeserialize(using = ClobDeserializer.class)
	private String summary;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Timestamp regdate;
	private String coverfile;
	private String userid;


}
