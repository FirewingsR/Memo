package com.hyprice.william.algorithms;

public abstract class BaseSort {
	public abstract void sort(int[] a, int len);
	// 交换
	public void swap (int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	// 打印完整序列
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
