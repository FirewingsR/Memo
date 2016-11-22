package com.hyprice.william.algorithms;

public class SelectionSort extends BaseSort {

	public static void main(String[] args) {
		// 调用选择排序方法
		SelectionSort selection = new SelectionSort();
		int[] array = selection.genArray(10, 10);
		System.out.print("排序前:\t");
		selection.printAll(array);
		selection.sort(array, array.length);
		System.out.print("排序后:\t");
		selection.printAll(array);

	}

	@Override
	public void sort(int[] a, int len) {
		// 需要遍历获得最小值的次数
		// 要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列
		for (int i = 0; i < len - 1; i++) {
			// 用来保存最小值得索引
			int index = i;
			// 寻找第i个小的数值
			for (int j = i + 1; j < len; j++) {
				if (a[index] > a[j]) {
					index = j;
				}
			}
			// 将找到的第i个小的数值放在第i个位置上
			swap(a, index, i);
			System.out.format("第 %d 趟:\t", i + 1);
			printAll(a);
		}
	}

}
