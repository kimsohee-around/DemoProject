package org.iclass.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Notice;
import org.iclass.vo.Paging;

import mybatis.SqlSessionBean;

public class NoticeDao {
	private static NoticeDao dao = new NoticeDao();
	private NoticeDao() {}
	public static NoticeDao getInstance() {
		return dao;
	}

//	페이지 목록 sql 을 위한 dao
	public List<Notice> list(Paging paging) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		List<Notice> list = mapperSession.selectList("notice.getList",paging);
		mapperSession.close();
		return list;
	}
	
	public int count(Map<String, String> map) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.selectOne("notice.count",map);
		mapperSession.close();
		return result;
	}

	
	
}
