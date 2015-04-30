package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import cn.gyyx.core.Slf4jFactory;
/**
 *用户地址数据处理类
 */
public class UserAddressDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;
	private static final Logger logger = Slf4jFactory.getLogger(UserAddressDAO.class);

	public UserAddressDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
