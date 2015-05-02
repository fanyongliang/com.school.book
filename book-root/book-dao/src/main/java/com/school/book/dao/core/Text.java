package com.school.book.dao.core;

/**
 * 
 */


/**
 * @author YangJiayi
 *
 */
public class Text {

	public static boolean isNullOrEmpty(String text) {
		return text == null || text.length() == 0;
	}

	public static boolean isNullOrWhitespace(String text) {
		return text == null || text.trim().length() == 0;
	}
}
