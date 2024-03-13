package org.iclass.dao;

public class NoticeDao {
	private static NoticeDao dao = new NoticeDao();
	private NoticeDao() {}
	public static NoticeDao getInstance() {
		return dao;
	}

	

	
	
}
