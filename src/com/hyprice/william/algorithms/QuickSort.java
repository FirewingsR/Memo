package com.hyprice.william.algorithms;

public class QuickSort extends BaseSort {

	@Override
	public void sort(int[] a, int len) {
		quickSort(a, 0, len - 1);
	}

	private void quickSort(int[] a, int left, int right) {
		// 左下标一定小于右下标，否则就越界了
		if (left < right) {
			// 对数组进行分割，取出下次分割的基准标号
			int base = division(a, left, right);

			System.out.format("base = %d:\t", a[base]);
			printPart(a, left, right);

			// 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
			quickSort(a, left, base - 1);

			// 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
			quickSort(a, base + 1, right);
		}
	}

	public int division(int[] a, int left, int right) {
	    // 以最左边的数(left)为基准
	    int base = a[left];
	    
	    while (left < right) {
	        // 从序列右端开始，向左遍历，直到找到小于base的数
	        while (left < right && a[right] >= base)
	            right--;
	        // 找到了比base小的元素，将这个元素放到最左边的位置
	        a[left] = a[right];
	 
	        // 从序列左端开始，向右遍历，直到找到大于base的数
	        while (left < right && a[left] <= base)
	            left++;
	        // 找到了比base大的元素，将这个元素放到最右边的位置
	        a[right] = a[left];
	    }
	 
	    // 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
	    // 而left位置的右侧数值应该都比left大。
	    a[left] = base;
	    
	    return left;
	}

	// 获取x这个数的d位数上的数字
	// 比如获取123的1位数，结果返回3
	public int getDigit(int x, int d) {
		int a[] = { 1, 1, 10, 100, 1000 }; // 本实例中的最大数是百位数，所以只要到100就可以了
		return ((x / a[d]) % 10);
	}

	public static void main(String[] args) {
		// 调用排序方法
		QuickSort quick = new QuickSort();
		int[] array = quick.genArray(10, 1000);
		quick.test(array);
	}

}
