package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

/*
 * 书评信息数据处理类
 */
public class BookReviewsDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public BookReviewsDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
