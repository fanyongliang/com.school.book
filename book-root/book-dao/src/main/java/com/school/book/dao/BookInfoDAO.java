package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 图书信息数据处理类
 */
public class BookInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public BookInfoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
