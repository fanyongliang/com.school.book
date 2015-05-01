package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 *用户详细信息数据处理类
 */
public class UserInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;
	public UserInfoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
