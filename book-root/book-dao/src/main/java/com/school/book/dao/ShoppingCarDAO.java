package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.core.Slf4jFactory;
/**
 * 购物车信息数据处理类
 */
public class ShoppingCarDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;

	public ShoppingCarDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
