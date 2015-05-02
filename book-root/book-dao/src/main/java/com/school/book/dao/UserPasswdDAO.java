package com.school.book.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.school.book.bean.UserPasswdBean;

/**
 *用户密码数据处理类
 */
public class UserPasswdDAO {
	
	private SqlSessionFactory sqlSessionFactory;

	public UserPasswdDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	/**
	 * 将用户信息录入到数据库中，用于记录录入的数量
	 * @param userInfo
	 * @return
	 */
	public void add(UserPasswdBean userPasswdBean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserPasswdMapper dao = session.getMapper(IUserPasswdMapper.class);
			dao.insertUserPasswd(userPasswdBean);
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public UserPasswdBean getUserPasswordByUserName(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserPasswdMapper dao = session.getMapper(IUserPasswdMapper.class);
			return dao.getUserPasswordByUserName(userName);
		} finally {
			session.close();
		}
	}
	
}
