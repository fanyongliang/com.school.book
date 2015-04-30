package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import cn.gyyx.core.Slf4jFactory;
/**
 * 订单数据处理类
 */
public class BookOrderDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;
	private static final Logger logger = Slf4jFactory.getLogger(BookOrderDAO.class);

	public BookOrderDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
