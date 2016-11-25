package com.hyprice.william.questions;

/**
 * @Description: Finding the longest no-repeated substring
 * @author Lihy10
 * @date 2013-9-30 am 09:28:14
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LCS {

	/**
	 * @Description:Main function @param args @throws
	 */
	public static void main(String[] args) {
		print(getLongestNoRepeatSubString("abeafb"));

	}

	/**
	 * @Description: Print @param list @throws
	 */
	@SuppressWarnings("rawtypes")
	private static void print(List list) {
		for (Iterator it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

	/**
	 * @Description: Get the longest noRepeat subString @param
	 * src @return @throws
	 */
	@SuppressWarnings("rawtypes")
	public static List getLongestNoRepeatSubString(String src) {
		char[] arr = src.toCharArray();
		int len = arr.length;// the length of the array
		List<String> subList = new ArrayList<String>();// which is used to save
														// the substring
		int max;// the length of the longest substring
		int start;// the start of the longest substring
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();// to
																			// save
																			// the
																			// substirng
		max = start = 0;
		int i;
		for (i = 0; i < len; i++) {
			if (!charMap.containsKey(arr[i])) {// if charMap don't include
												// arr[i],then put it into
												// charMap
				charMap.put(arr[i], i);
			} else {
				int pre = charMap.get(arr[i]);
				int tempLen = i - start;// the length of the current substring
				if (tempLen >= max) {
					if (tempLen > max)
						subList.clear();// Refresh
					max = tempLen;
					subList.add(src.substring(start, i));// save
					charMap.put(arr[i], i);
				} else {
					charMap.put(arr[i], i);
				}
				start = pre + 1;// reset the start position
			}
		}
		if (i - start >= max) {// to deal with the no-repeated String
			if (i - start > max)
				subList.clear();
			subList.add(src.substring(start, i));
		}
		return subList;
	}
}