package com.bob.sort;

/**
 * @Author wangbo
 * @Date 2022/11/11 10:43
 * @Description: 堆排序
 * @Version 1.0
 * <p>
 * 分析：
 * 1.构建顶堆
 * ①若排序从小到大，则需要大顶堆
 * ②若排序从大到小，则需要小顶堆
 * 2.顶堆数据迁移
 */
public class HeapSort {

	// 自己错误的代码
	// 花了2个小时写的代码还是错误,反思

//	/**
//	 * 堆排序
//	 *
//	 * @param nums 待排序节点
//	 * @return 排序后待结果集
//	 */
//	public static int[] heapSort(int[] nums) {
//		// 1.构建顶堆
//		buildHeapTree(nums);
//		// 2.从顶堆开始迁移
//
//		return nums;
//	}
//
//	private static void buildHeapTree(int[] nums) {
//		// 最大层数
//		int layerCount = findHeapHeight(nums);
//		// 开始遍历构建数组
//		int swapStart = findSwapStart(nums, layerCount);
//		do {
//			buildNode(nums, swapStart);
//			swapStart--;
//		} while (swapStart > 0);
//
//	}
//
//	private static void buildNode(int[] nums, int swapStart) {
//		if (swapStart >= nums.length || swapStart << 1 >= nums.length){
//			return;
//		}
//		boolean isRight = false;
//		if ((swapStart << 1) + 1 < nums.length) {
//			isRight = true;
//		}
//		if (isRight && nums[swapStart << 1] < nums[swapStart - 1] && nums[(swapStart << 1) - 1] < nums[swapStart - 1]) {
//			return;
//		}
//		if (nums[(swapStart << 1) - 1] < nums[swapStart - 1]) {
//			return;
//		}
//		if (isRight && nums[swapStart << 1] > nums[swapStart - 1] && nums[swapStart << 1] > nums[(swapStart << 1) - 1]) {
//			int temp = nums[swapStart - 1];
//			nums[swapStart - 1] = nums[swapStart << 1];
//			nums[swapStart << 1] = temp;
//		}
//		if (isRight && nums[(swapStart << 1) - 1] > nums[swapStart - 1] && nums[swapStart << 1] < nums[(swapStart << 1) - 1]) {
//			int temp = nums[swapStart - 1];
//			nums[swapStart - 1] = nums[(swapStart << 1) - 1];
//			nums[(swapStart << 1) - 1] = temp;
//		}
//		if (nums[(swapStart << 1) - 1] > nums[swapStart - 1]) {
//			int temp = nums[swapStart - 1];
//			nums[swapStart - 1] = nums[(swapStart << 1) - 1];
//			nums[(swapStart << 1) - 1] = temp;
//		}
//		buildNode(nums, swapStart << 1);
//		buildNode(nums, (swapStart << 1) + 1);
//
//	}
//
//
//	private static int findSwapStart(int[] nums, int layerCount) {
//		int count = (1 << (layerCount - 1)) - 1;
//		if ((1 << layerCount) - 1 == nums.length || (1 << layerCount) - 1 == nums.length - 1) {
//			return count;
//		}
//		return count - (((1 << layerCount) - 1 - count) / 2 - ((nums.length - count) / 2 + (nums.length - count) % 2));
//
//	}
//
//	private static int findHeapHeight(int[] nums) {
//		int count = 0;
//		while (1 << count - 1 < nums.length) {
//			count++;
//		}
//		return count - 1;
//	}


	/**
	 * 建一个大顶堆
	 *
	 * @param data  数据源
	 * @param start 开始点
	 * @param end   end表示最多建到的点
	 */
	public static void maxHeap(int data[], int start, int end) {
		int parent = start;
		int son = parent * 2 + 1;
		while (son < end) {
			int temp = son;
			// 比较左右节点和父节点的大小
			// 表示右节点比左节点到
			if (son + 1 < end && data[son] < data[son + 1]) {
				// 就要换右节点跟父节点
				temp = son + 1;
			}
			// temp表示的是 我们左右节点大的那一个
			if (data[parent] > data[temp]) {
				// 不用交换
				return;
			} else {
				// 交换
				int t = data[parent];
				data[parent] = data[temp];
				data[temp] = t;
				// 继续堆化
				parent = temp;
				son = parent * 2 + 1;
			}
		}
		return;

	}

	/**
	 * 数据源
	 *
	 * @param data 结果集
	 */
	public static void heapSort(int data[]) {
		int len = data.length;
		for (int i = len / 2 - 1; i >= 0; i--) {
			maxHeap(data, i, len);
		}
		for (int i = len - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			maxHeap(data, 0, i);
		}
	}
}
