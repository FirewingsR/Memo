package com.hyprice.william.algorithms;

public class InsertSort extends BaseSort {

	@Override
	public void sort(int[] a, int len) {
		// 打印第一个元素
		System.out.format("i = %d:\t\t", 0);
		printPart(a, 0, 0);
		// 第一个数是有序的，从第二个数正序遍历，依次插入有序序列
		for (int i = 1; i < len; i++) {
			// 从第 i 个位置，倒序遍历，如果比之前元素小交换
			for (int j = i; j - 1 >= 0; j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j, j - 1);
				} else {
					break;
				}
			}
			System.out.format("i = %d:\t\t", i);
			printPart(a, 0, i);
		}
	}

	public static void main(String[] args) {
		// 调用排序方法
		InsertSort insert = new InsertSort();
		int[] array = insert.genArray(10, 10);
		insert.test(array);
	}

}
