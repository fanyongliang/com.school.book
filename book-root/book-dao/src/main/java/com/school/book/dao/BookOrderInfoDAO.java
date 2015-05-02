package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 订单信息数据处理类
 */
public class BookOrderInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public BookOrderInfoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
