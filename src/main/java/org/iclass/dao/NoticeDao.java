package org.iclass.dao;


import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Notice;
import org.iclass.vo.Paging;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Notice;


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

//	글쓰기
	public int write(Notice notice) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.insert("notice.insert",notice);
		mapperSession.commit();
		mapperSession.close();
		return result;
	}

//  글읽기
	public Notice read(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		Notice vo = mapperSession.selectOne("notice.getOne",idx);
		mapperSession.close();
		return vo;
	}
	public int setReadCount(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.insert("notice.setReadCount",idx);
		mapperSession.commit();
		mapperSession.close();
		return result;
		
	}
}
