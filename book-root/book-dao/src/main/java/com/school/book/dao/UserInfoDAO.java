package com.school.book.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.school.book.bean.UserInfoBean;

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
	/**
	 * 将用户信息录入到数据库中，返回一个Integer值，用于记录录入的数量
	 * @param userInfo
	 * @return
	 */
	public void add(UserInfoBean userInfoBean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserInfoMapper dao = session.getMapper(IUserInfoMapper.class);
			dao.insertUserInfo(userInfoBean);
		} finally {
			session.commit();
			session.close();
		}
	}

	/**
	 * 根据用户账号查询数据库中的记录，返回一个用户实体
	 * @param info_account
	 * @return
	 */
	public UserInfoBean selectByUserName(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserInfoMapper dao = session.getMapper(IUserInfoMapper.class);
			return dao.selectByUserName(userName);
		} finally {
			session.close();
		}
	}
//	/**
//	 * 查询所有的用户
//	 * @return
//	 */
//	public List<UserInfo> selectAllUsers() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			IUserInfoDAO dao = session.getMapper(IUserInfoDAO.class);
//			return dao.selectAllUsers();
//		} finally {
//			session.close();
//		}
//	}
//	/**
//	 * 根据关键字查询数据库返回一个List集合
//	 * @param key
//	 * @return
//	 */
//	public List<UserInfo> selectByKey(String key) {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			IUserInfoDAO dao = session.getMapper(IUserInfoDAO.class);
//			return dao.selectByKey(key);
//		} finally {
//			session.close();
//		}
//	}
//	/**
//	 * 根据页码查询匹配的用户数据，返回一个List集合
//	 * @param page
//	 * @return
//	 */
//	public List<UserInfo> selectByPage(int page) {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			IUserInfoDAO dao = session.getMapper(IUserInfoDAO.class);
//			return dao.selectByPage(page);
//		} finally {
//			session.close();
//		}
//	}
//	/**
//	 * 查询数据库中所有记录的总条数
//	 * @return
//	 */
//	public Integer selectCount() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			IUserInfoDAO dao = session.getMapper(IUserInfoDAO.class);
//			return dao.selectCount();
//		} finally {
//			session.close();
//		}
//	}
//	/**
//	 * 根据用户名删除用户
//	 */
//	public Integer deleteByAccount(String info_account) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	/**
//	 * 更新用户的信息
//	 */
//	public Integer update(UserInfo userInfo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
