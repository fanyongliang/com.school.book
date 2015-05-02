package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 导航信息数据处理类
 */
public class NavListDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public NavListDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
