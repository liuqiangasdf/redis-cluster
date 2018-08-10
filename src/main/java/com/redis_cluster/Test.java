package com.redis_cluster;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 6, 5, 4, 3 };
		insertOrder(array);
	}

	// 插入排序
	private static void insertOrder(int[] array) {
		int count = 0;
		// 本轮排序范围
		for (int i = 0; i < array.length; i++) {
			System.out.println("排序范围" + (i + 1));
			for (int j = i - 1; j >= 0; j--) {
				System.out.println("排序前" + Arrays.toString(Arrays.copyOf(array, i + 1)));
				int temp;
				count++;
				// 从后往前判断
				if (array[j + 1] < array[j]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				} else {
					break;
				}
				System.out.println("排序后" + Arrays.toString(Arrays.copyOf(array, i + 1)));
			}
		}
		System.out.println(count);
	}
}
