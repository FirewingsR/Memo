package com.hyprice.william.algorithms;

public class HeapSort2 extends BaseSort {

	@Override
	public void sort(int[] a, int len) {
		buildMaxHeapify(a, len);
		heapSort(a, len);
		print(a);
	}

	private void buildMaxHeapify(int[] a, int len) {
		// 没有子节点的才需要创建最大堆，从最后一个的父节点开始
		int startIndex = getParentIndex(len - 1);
		// 从尾端开始创建最大堆，每次都是正确的堆
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(a, len, i);
		}
	}

	/**
	 * 创建最大堆
	 *
	 * @param a
	 * @param heapSize:需要创建最大堆的大小，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
	 * @param index:当前需要创建最大堆的位置
	 */
	private void maxHeapify(int[] a, int heapSize, int index) {
		// 当前点与左右子节点比较
		int left = getChildLeftIndex(index);
		int right = getChildRightIndex(index);

		int largest = index;
		if (left < heapSize && a[index] < a[left]) {
			largest = left;
		}
		if (right < heapSize && a[largest] < a[right]) {
			largest = right;
		}
		// 得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
		if (largest != index) {
			// int temp = a[index];
			// a[index] = a[largest];
			// a[largest] = temp;
			swap(a, index, largest);
			maxHeapify(a, heapSize, largest);
		}
	}

	/**
	 * 排序，最大值放在末尾，a虽然是最大堆，在排序后就成了递增的
	 *
	 * @param a
	 */
	private void heapSort(int[] a, int len) {
		// 末尾与头交换，交换后调整最大堆
		for (int i = len - 1; i > 0; i--) {
			// int temp = data[0];
			// data[0] = data[i];
			// data[i] = temp;
			swap(a, 0, i);
			maxHeapify(a, i, 0);
		}
	}

	/**
	 * 父节点位置
	 *
	 * @param current
	 * @return
	 */
	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}

	/**
	 * 左子节点position注意括号，加法优先级更高
	 *
	 * @param current
	 * @return
	 */
	private static int getChildLeftIndex(int current) {
		return (current << 1) + 1;
	}

	/**
	 * 右子节点position
	 *
	 * @param current
	 * @return
	 */
	private static int getChildRightIndex(int current) {
		return (current << 1) + 2;
	}

	private static void print(int[] data) {
		int pre = -2;
		for (int i = 0; i < data.length; i++) {
			if (pre < (int) getLog(i + 1)) {
				pre = (int) getLog(i + 1);
				System.out.println();
			}
			System.out.print(data[i] + "|");
		}
		System.out.println();
	}

	/**
	 * 以2为底的对数
	 * 
	 * @param param
	 * @return
	 */
	private static double getLog(double param) {
		return Math.log(param) / Math.log(2);
	}

	public static void main(String[] args) {
		// 调用排序方法
		HeapSort2 heap = new HeapSort2();
		int[] array = heap.genArray(10, 10);
		heap.test(array);
	}
}