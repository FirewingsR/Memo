package com.hyprice.william.questions;

public class CharCount {

	/*
	 * 2. 给一串字符串比如abbbcccd，输出a1b3c3d1，手写代码（注意有个别字符可能会出现十次以上的情况）
	 */
	public static void main(String[] args) {
		String str = "abbbcccd";

		str = str.toLowerCase().trim();

		int[] bucket = new int[26];

		int count = str.length();

		for (int i = 0; i < count; i++) {
			char c = str.charAt(i);
			int index = c - 97;
			bucket[index]++;
		}

		StringBuilder sb = new StringBuilder(128);

		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] > 0) {
				String s = String.valueOf((char) (i + 97));
				sb.append(s + bucket[i]);
			}
		}
		
		System.out.println(sb.toString());
	}
	
}