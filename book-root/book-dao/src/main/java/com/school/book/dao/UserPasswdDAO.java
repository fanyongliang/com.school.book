package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.core.Slf4jFactory;

/**
 *用户密码数据处理类
 */
public class UserPasswdDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public UserPasswdDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
