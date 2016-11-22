package com.hyprice.william.algorithms;

import java.util.Random;

public abstract class BaseSort {
	// 排序
	public abstract void sort(int[] a, int len);

	// 生成测试数据
	public int[] genArray(int len, int multiple) {
		final int MAX_SIZE = len;
		int[] array = new int[MAX_SIZE];
		Random random = new Random();
		for (int i = 0; i < MAX_SIZE; i++) {
			array[i] = random.nextInt(MAX_SIZE * multiple);
		}
		return array;
	}

	// 交换
	public void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	// 打印序列
	public void printPart(int[] list, int begin, int end) {
		for (int i = 0; i < begin; i++) {
			System.out.print("\t");
		}
		for (int i = begin; i <= end; i++) {
			System.out.print(list[i] + "\t");
		}
		System.out.println();
	}

	// 打印完整序列
	public void printAll(int[] list) {
		for (int value : list) {
			System.out.print(value + "\t");
		}
		System.out.println();
	}
}
