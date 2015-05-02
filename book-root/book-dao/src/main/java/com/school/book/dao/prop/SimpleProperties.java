package com.school.book.dao.prop;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：Java类库
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年11月28日 上午9:13:46
 * @版本号：
 * @本类主要用途描述:懒汉式模式将PropertiesParser类设置为单例
 *-------------------------------------------------------------------------
 */


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.school.book.dao.core.Environment;

/**
 * 懒汉式单例模式将PropertiesParser类设置为单例
 */
public class SimpleProperties {

	private static volatile byte[] locker = new byte[0];
	private static PropertiesParser propertiesParser = null;

	private SimpleProperties() {
	}

	/**
	 * 得到PropertiesParser对象
	 * 
	 * @Title: getInstance
	 * @return PropertiesParser
	 */
	public static PropertiesParser getInstance() {

		if (propertiesParser != null) {
			return propertiesParser;
		}

		String appPropName = "app.properties";

		switch (Environment.getOS()) {
		case Unix:
		case Mac:
			appPropName = "app_unix.properties";
			break;
		case Windows:
			appPropName = "app_win.properties";
			break;
		}

		synchronized (locker) {
			if (propertiesParser != null) {
				return propertiesParser;
			}

			//读取配置文件中多个以path开头的属性名，并转化为数组
			Properties appProp = new PropertiesParser(appPropName)
					.getPropertyGroup("path");
			String[] array = new String[appProp.size()];
			appProp.values().toArray(array);		
			propertiesParser = new PropertiesParser(array);
			return propertiesParser;
		}
	}

}
