package com.bob.hash;

/**
 * @Author wangbo
 * @Date 2022/11/23 10:06
 * @Description: bitmap 这里又一个坑,int 首位是符号位,存在一个优化点,long类型有空间无用
 * @Version 1.0
 */
public class BitMap {

	private long[] bits;

	private final static int INIT_MOVE = 5;

	/**
	 * 初始化
	 *
	 * @param max 最大数
	 */
	public BitMap(int max) {
		if (max < 1) {
			throw new NullPointerException("");
		}
		// 初始化容量大小
		bits = new long[(max >>> INIT_MOVE) + 1];
	}

	/**
	 * 添加元素
	 *
	 * @param value 待添加的数据
	 */
	public void add(int value) {
		int move = value >>> INIT_MOVE;
		bits[move] = bits[move] | getRealLocation(value, move);
	}

	/**
	 * 移除元素
	 *
	 * @param value 待移除的元素
	 */
	public void delete(int value) {
		int move = value >> INIT_MOVE;
		bits[move] = bits[move] & (~getRealLocation(value, move));
	}

	/**
	 * 判断元素是否存在
	 *
	 * @param value 待判断的元素
	 * @return 存在true 不存在false
	 */
	public boolean exist(int value) {
		int move = value >> INIT_MOVE;
		return (bits[move] & getRealLocation(value, move)) > 0;
	}

	private long getRealLocation(int value, int move) {
		long count = value - (1 << INIT_MOVE) * move;
		return 1L << count;
	}
}
