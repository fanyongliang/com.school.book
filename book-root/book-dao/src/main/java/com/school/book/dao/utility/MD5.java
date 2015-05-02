package com.school.book.dao.utility;


/**------------------------------------------------------------------------- 
* 版权所有：
* 作者：
* 联系方式：
* 创建时间： 2014/8/19 18:37:16 
* 版本号：v1.0 
* 本类主要用途描述： 
* MD5算法
-------------------------------------------------------------------------**/ 


import java.security.MessageDigest;

public class MD5 {
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
		            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String encode(String origin) {

		try {
			MessageDigest md5;
			md5 = MessageDigest.getInstance("MD5");
			byte[] raw = origin.getBytes("UTF-8");
			byte[] bytes=md5.digest(raw);
			int len = bytes.length;
			
			StringBuilder buf = new StringBuilder(len * 2);
			
			// 把密文转换成十六进制的字符串形式
			
			for (int j = 0; j < len; j++) {          
				buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			
				buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
			
			}
			
			return buf.toString();

		} catch (Exception e) {
			
		} 

		return null;

	}

}

