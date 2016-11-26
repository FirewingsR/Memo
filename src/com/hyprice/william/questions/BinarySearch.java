package com.hyprice.william.questions;

/*
 * 已理解
 */
public class BinarySearch {
	
	private static int search(int[] arr, int des) {
		int low = 0;
		int high = arr.length - 1;

		final int maxIndex = arr.length - 1;

		while ((low <= high) && (low <= maxIndex) && (high <= maxIndex)) {
			int middle = (high + low) >> 1;
			if (des == arr[middle]) {
				return middle;
			} else if (des < arr[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 2323, 4, 67, 8, 523, 343, 5, 4324324 };
		int index = search(arr, 8);
		System.out.println(index);
	}
}
