package org.iclass.dao;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Notice;

import mybatis.SqlSessionBean;

public class NoticeDao {
	private static NoticeDao dao = new NoticeDao();
	private NoticeDao() {}
	public static NoticeDao getInstance() {
		return dao;
	}

//	글쓰기
	public int write(Notice notice) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.insert("notice.insert",notice);
		mapperSession.commit();
		mapperSession.close();
		return result;
	}
	
}
