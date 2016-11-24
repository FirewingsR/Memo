package com.hyprice.william.questions;

public class FindMax {

	/*
	 * 3. 一个序列，它的形式是12349678，9是最高峰，经历了一个上升又下降的过程，找出里面的最大值的位置，要求效率尽可能高
	 */
	public static void main(String[] args) {
		String str = "12349678";

		byte[] a = str.getBytes();

		byte max = 0;

		for (int i = 0; i < a.length; i++) {
			byte c = a[i];
			if (c > max) {
				max = c;
			} else {
				System.out.println(i);
				break;
			}
		}

		System.out.println((char) max);
	}
	
}