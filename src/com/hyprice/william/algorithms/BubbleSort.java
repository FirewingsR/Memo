package com.hyprice.william.algorithms;

/*
 * 已理解
 */
public class BubbleSort extends BaseSort {

	@Override
	public void sort(int[] a, int len) {
		// 正序遍历 n-1 次
		boolean bChange = false;
		for (int i = 0; i < len - 1; i++) {
			bChange = false;
			// 倒序遍历 n-1-i 次
			for (int j = len - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					bChange = true;
				}
			}
			if (false == bChange) {
				break;
			}
			System.out.format("第 %d 趟：\t\t", i);
            printAll(a);
		}
	}

	public static void main(String[] args) {
		// 调用排序方法
		BubbleSort bubble = new BubbleSort();
		int[] array = bubble.genArray(10, 10);
		bubble.test(array);
	}

}
