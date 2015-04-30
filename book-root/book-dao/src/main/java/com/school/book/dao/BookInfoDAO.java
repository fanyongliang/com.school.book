package com.school.book.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import cn.gyyx.core.Slf4jFactory;
/**
 * 图书信息数据处理类
 */
public class BookInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IUserPasswdMapper iUserPasswdMapper ;
	private static final Logger logger = Slf4jFactory.getLogger(BookInfoDAO.class);

	public BookInfoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
}
