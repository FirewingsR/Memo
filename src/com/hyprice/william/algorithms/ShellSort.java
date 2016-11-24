package com.hyprice.william.algorithms;

/*
 * 已理解
 */
public class ShellSort extends BaseSort {

	@Override
	public void sort(int[] a, int len) {
		int gap = len / 2;
		// 第一个数是有序的，从第二个数正序遍历，依次插入有序序列
		while (1 <= gap) {
			
//			for (int i = 1; i < len; i++) {
//				// 从第 i 个位置，倒序遍历，如果比之前元素小交换
//				for (int j = i; j - 1 >= 0; j--) {
//					if (a[j] < a[j - 1]) {
//						swap(a, j, j - 1);
//					} else {
//						break;
//					}
//				}
//				System.out.format("i = %d:\t\t", i);
//				printPart(a, 0, i);
//			}
			
			for (int i = gap; i < len; i++) {
				// 从第 i 个位置，倒序遍历，如果比之前元素小交换
				for (int j = i; j - gap >= 0; j-=gap) {
					if (a[j] < a[j - gap]) {
						swap(a, j, j - gap);
					} else {
						break;
					}
				}
			}
			
			System.out.format("gap = %d:\t", gap);
			printAll(a);
            
			gap /= 2;
		}
	}

	public static void main(String[] args) {
		// 调用排序方法
		ShellSort shell = new ShellSort();
		int[] array = shell.genArray(10, 10);
		shell.test(array);
	}

}
