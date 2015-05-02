package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 订单数据处理类
 */
public class BookOrderDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public BookOrderDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
