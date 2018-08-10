package com.redis_cluster;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 6, 5, 4, 3 };
		insertOrder(array);
		// selectOrder(array);
		// BubbleOrder(array);
	}

	/**
	 * 插入排序
	 * <p>
	 * 每轮前N个元素进行从后往前排序
	 * 
	 * @param array
	 */
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

	/**
	 * 选择排序
	 * <p>
	 * 每轮找到剩下中最小值的下标记录并和当前值交换
	 * 
	 * @param array
	 */
	private static void selectOrder(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			int temp;
			for (int j = i + 1; j < array.length; j++) {
				count++;
				if (array[j] < array[index]) {
					index = j;
				}
			}
			if (array[index] < array[i]) {
				temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
			System.out.println("排序后" + Arrays.toString(array));
		}
		System.out.println(count);
	}

	/**
	 * 冒泡排序
	 * <p>
	 * 每轮前N个元素进行从后往前排序
	 * 
	 * @param array
	 */
	private static void BubbleOrder(int[] array) {
		int count = 0;
		// 本轮排序范围
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int temp;
				count++;
				if (array[j] < array[j - 1]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
				System.out.println("排序后" + Arrays.toString(array));
			}
		}
		System.out.println(count);
	}
	
	
	
	
	
}
