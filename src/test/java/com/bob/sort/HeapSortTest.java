package com.bob.sort;

import java.util.Arrays;

/**
 * @Author wangbo
 * @Date 2022/11/11 17:33
 * @Description: 堆排序
 * @Version 1.0
 */
public class HeapSortTest {
	public static void main(String[] args) {
		int[] nums = new int[]{8, 4, 20, 7, 3, 1, 25, 14, 17};
		HeapSort.heapSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
