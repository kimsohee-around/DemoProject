package org.iclass.dao;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewBooks;

import mybatis.SqlSessionBean;

public class NewBooksDao {
	private static NewBooksDao dao = new NewBooksDao();
	private NewBooksDao() {}
	public static NewBooksDao getInstance() {
		return dao;
	}
	
	public static Clob clobConvert(String temp) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		Clob clob =null;
		try {
			clob = sqlSession.getConnection().createClob();
			clob.setString(1,temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clob;
	}

	public List<NewBooks> list() {
		SqlSession sqlSession = SqlSessionBean.getSession();
		List<NewBooks> list = sqlSession.selectList("books.listAll");
		sqlSession.close();
		return list;
	}
	
	public NewBooks bookOne(int idx) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		NewBooks book = sqlSession.selectOne("books.getOne",idx);
		sqlSession.close();
		return book;
	}
	
	public int insert(NewBooks book) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		int result = sqlSession.insert("books.insert",book);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}
