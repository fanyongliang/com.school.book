package com.school.book.bll;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;

import com.school.book.bean.UserInfoBean;
import com.school.book.bean.UserPasswdBean;
import com.school.book.dao.UserInfoDAO;
import com.school.book.dao.UserPasswdDAO;

/**
 * 登陆和注册的业务层
 */
public class LandAndRegistrationBll {
	/**
	 * 实例化
	 */
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private UserPasswdDAO userPasswdDAO = new UserPasswdDAO();
	
	private static LandAndRegistrationBll landAndRegistrationBll = new LandAndRegistrationBll();
	private MD5BLL md5 = new MD5BLL();

	/**
	 * 注册时检查用户名是否存在
	 * @param info_account
	 * @return
	 */
	public Boolean checkRegisterUserName(String userName) {
		if (landAndRegistrationBll.getUserInfoBySelect(userName) == null) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 登录时检查用户名或密码是否正确
	 * @param userLogin_account
	 * @param userLogin_password
	 * @return
	 */
	public Boolean checkLoginAccount(String userName,
			String userPasswd) {
		UserPasswdBean userPasswdBean = userPasswdDAO
				.getUserPasswordByUserName(userName);
		String newPassword = md5.getPassword(userPasswd, userPasswdBean.getPasswdKey());
		if (userPasswdBean != null
				&& userPasswdBean.getUserPasswd().equals(newPassword)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 添加Memcache，保存用户信息到Memcache中
	 * @param key
	 * @param users
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws MemcachedException
	 */
	public void setMem(String key, UserInfoBean userInfoBean) throws IOException,
			TimeoutException, InterruptedException, MemcachedException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				"127.0.0.1:11211");
		MemcachedClient client = builder.build();
		client.set(key, 0, userInfoBean);
	}
	/**
	 * 验证Memcache，从Memcache中查询数据
	 * @param value
	 * @return
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws MemcachedException
	 */
	public Object getMem(String value) throws IOException, TimeoutException,
			InterruptedException, MemcachedException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				"127.0.0.1:11211");
		MemcachedClient client = builder.build();
		return client.get(value);
	}

	/**
	 * 添加用户信息到数据库中，并对密码MD5加密
	 * @param userInfo
	 * @return
	 */
	public void addUserInfo(UserInfoBean userInfoBean) {
		UserPasswdBean userPasswdBean = new UserPasswdBean();
		String[] password = md5.changePassword(userInfoBean.getUserPasswd());
		userPasswdBean.setUserName(userInfoBean.getUserName());
		userPasswdBean.setUserPasswd(password[1]);
		userPasswdBean.setPasswdKey(password[0]);
		userPasswdBean.setUserType(2);
		userPasswdDAO.add(userPasswdBean);
		userInfoDAO.add(userInfoBean);
	}
	/**
	 * 返回通过用户名查找到的用户信息
	 * @param info_account
	 * @return
	 */
	public UserInfoBean getUserInfoBySelect(String userName) {
		return userInfoDAO.selectByUserName(userName);
	}

}
