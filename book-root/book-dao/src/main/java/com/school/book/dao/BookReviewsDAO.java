package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import cn.gyyx.core.Slf4jFactory;
/*
 * 书评信息数据处理类
 */
public class BookReviewsDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;
	private static final Logger logger = Slf4jFactory.getLogger(BookReviewsDAO.class);

	public BookReviewsDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
