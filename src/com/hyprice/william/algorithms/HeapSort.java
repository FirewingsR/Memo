package com.hyprice.william.algorithms;

import java.util.Random;

public class HeapSort extends BaseSort {

	@Override
	public void sort(int[] a, int len) {
		// 循环建立初始堆
		for (int i = len / 2; i >= 0; i--) {
			HeapAdjust(a, i, len - 1);
		}

		// 进行n-1次循环，完成排序
		for (int i = len - 1; i > 0; i--) {
			// 最后一个元素和第一元素进行交换
			swap(a, 0, i);
			
			// 筛选 R[0] 结点，得到i-1个结点的堆
			HeapAdjust(a, 0, i);
			
			System.out.format("第 %d 趟: \t", len - i);
			printPart(a, 0, len - 1);
		}
	}

	private void HeapAdjust(int[] a, int parent, int length) {

		// temp保存当前父节点
		int temp = a[parent];
		// 先获得左孩子
		int child = 2 * parent + 1;

		while (child < length) {
			// 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
			if (child + 1 < length && a[child] < a[child + 1]) {
				child++;
			}

			// 如果父结点的值已经大于孩子结点的值，则直接结束
			if (temp >= a[child])
				break;

			// 把孩子结点的值赋给父结点
			a[parent] = a[child];

			// 选取孩子结点的左孩子结点,继续向下筛选
			parent = child;
			child = 2 * parent + 1;
		}

		a[parent] = temp;
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

	public static void main(String[] args) {
		// 初始化一个序列
		final int MAX_SIZE = 10;
		int[] array = new int[MAX_SIZE];
		Random random = new Random();
		for (int i = 0; i < MAX_SIZE; i++) {
			array[i] = random.nextInt(MAX_SIZE * 10);
		}

		// 调用快速排序方法
		HeapSort heap = new HeapSort();
		System.out.print("排序前:\t\t");
		heap.printPart(array, 0, array.length - 1);
		heap.sort(array, array.length);
		System.out.print("排序后:\t\t");
		heap.printPart(array, 0, array.length - 1);
	}

}
