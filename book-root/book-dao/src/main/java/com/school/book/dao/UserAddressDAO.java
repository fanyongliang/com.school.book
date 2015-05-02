package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 *用户地址数据处理类
 */
public class UserAddressDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public UserAddressDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
