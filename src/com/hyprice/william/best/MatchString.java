package com.hyprice.william.best;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchString {

	/**
	 * 手写简单正则表达式
	 * @param exp
	 * @param str
	 * @return
	 */
	public static boolean isMatch(String exp, String str) {

		char[] e = exp.toCharArray();
		char[] s = str.toCharArray();

		// 表达式中的普通字符 index
		int eIndex = -1;
		
		// 匹配表达式的字符 index，可能不匹配
		int sIndex = -1;
		
		// 最后字符匹配的 index
		int lastMatchIndex = -1;
		
		// 谢词匹配 index 范围
		int nextMax = 0;
		
		for (int i = 0; i < e.length; i++) {
			if (e[i] != '*' && e[i] != '?') { // 一般字符
				eIndex = i;
				// 从上次匹配的 index + 1 开始找
				sIndex = str.indexOf(e[i], lastMatchIndex + 1);
				if (sIndex > -1) {
					System.out.println("s[sIndex]=" + s[sIndex]);
				}
				// 如果找到且小于等于预期位置
				if (sIndex > -1 && sIndex <= lastMatchIndex + nextMax) { // 包含
					// 纪录匹配 index
					lastMatchIndex = sIndex;
					// 预期 index 范围不再累计
					nextMax = 1;
				} else {
					return false;
				}
			} else if (e[i] == '?') {
				// 任意匹配
				lastMatchIndex += 0;
				// 0,1 预期 index 范围累计
				nextMax += 1;
			} else if (e[i] == '*') {
				// 最后的 index - 匹配的 index
				nextMax = s.length - 1 - lastMatchIndex;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		String exp = "*a????????bcd";
		String str = "abcd";
		
		boolean result = isMatch(exp, str);
		
		System.out.println(result);
		
		String exp1 = "^*a??bc";
		String str1 = "addbc";
		
		Pattern pattern = Pattern.compile(exp1);
		Matcher matcher = pattern.matcher(str1);
		
		System.out.println(matcher.matches());
	}

}
