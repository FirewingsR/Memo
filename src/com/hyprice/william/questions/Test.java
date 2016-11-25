package com.hyprice.william.questions;

public class Test {

	public static void main(String[] args) {

		String str1 = "abcabcabcabc";
		String str2 = "abcabcabcabc";
		System.out.println(String.class.getName());
		System.out.println(str1 == str2);

		Byte b1 = 100;
		Byte b2 = 100;
		System.out.println(Byte.class.getName());
		System.out.println(b1 == b2);

		Short s1 = 1000;
		Short s2 = 1000;
		System.out.println(Short.class.getName());
		System.out.println(s1 == s2);

		Integer i1 = 1000;
		Integer i2 = 1000;
		System.out.println(Integer.class.getName());
		System.out.println(i1 == i2);

		Long l1 = 1000l;
		Long l2 = 1000l;
		System.out.println(Long.class.getName());
		System.out.println(l1 == l2);

		Character c1 = 1000;
		Character c2 = 1000;
		System.out.println(Character.class.getName());
		System.out.println(c1 == c2);

		Boolean bb1 = true;
		Boolean bb2 = true;
		System.out.println(Boolean.class.getName());
		System.out.println(bb1 == bb2);

		/*
		 * 结论：
		 * 1.基本数据类型与其包装类运算或比较时，会自动拆箱成基本数据类型；
		 * 2.在自动装装箱时，会先检查其值是否在-128到127之间，如果在这之间，就会直接指向常量池中其值的地址;
		 * 3.只要是new得到的一定是对象，存在堆内存中； 4.同时byte, short, long也具有该特性。
		 * 原因：JVM做的一些一些优化，将常用的基本数据类型在程序运行时就创建加载在常量池中。
		 */

		Float f1 = 100f;
		Float f2 = 100f;
		System.out.println(Float.class.getName());
		System.out.println(f1 == f2);

		Double d1 = 100d;
		Double d2 = 100d;
		System.out.println(Double.class.getName());
		System.out.println(d1 == d2);

		/*
		 * 结论：float,double类型的包装类，都会在堆中创建一个新对象，因此比较的是对象的地址
		 */
	}

}
