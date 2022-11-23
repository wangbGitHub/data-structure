package com.bob.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangbo
 * @Date 2022/11/14 11:11
 * @Description: 广度优先遍历-数组
 * @Version 1.0
 */
public class GraphArrayBfs {
	/**
	 * 地图的行
	 */
	private int n;
	/**
	 * 地图的列
	 */
	private int m;
	/**
	 * 找寻 x
	 */
	private int dx;
	/**
	 * 找寻 y
	 */
	private int dy;
	/**
	 * 邻接矩阵
	 */
	private int data[][];

	/**
	 * 标记走过点
	 */
	private boolean mark[][];

	/**
	 * 最短路径长度
	 */
	private int MINSTEP = Integer.MAX_VALUE;

	private List<int[]> WAY = new ArrayList<>();

	/**
	 * 地图能走的值
	 */
	private final static int[][] DISPLACEMENT_ARRAY = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public GraphArrayBfs(int n, int m, int dx, int dy, int[][] data) {
		if (n < 1 || m < 1) {
			throw new NullPointerException("n,m 必须大于0");
		}
		this.n = n;
		this.m = m;
		if (dx > n || dy > m) {
			throw new NullPointerException("dx,dy 没有当前坐标点");
		}
		this.dx = dx;
		this.dy = dy;
		if (data == null) {
			throw new NullPointerException("未告知坐标体系");
		}
		this.data = data;
		this.mark = new boolean[m][n];
	}

	/**
	 * 广度优先遍历
	 *
	 * @param x    当前的位置 x
	 * @param y    当前的位置 y
	 * @param step 当前走过路径的长度
	 * @return
	 */
	public void dfs(int x, int y, int step,List<int[]> way) {
		if (way == null ){
			way = new ArrayList<>();
		}
		if (x + 1 == dx && y + 1 == dy) {
			if (MINSTEP > step) {
				MINSTEP = step;
				WAY = way;
			}
			return;
		}
		if (x < 0 || y < 0 || x >= n || y >= m) {
			return;
		}
		for (int i = 0; i < DISPLACEMENT_ARRAY.length; i++) {
			int[] displacement = DISPLACEMENT_ARRAY[i];
			if (x + displacement[0] >= n || y + displacement[1] >= m || x + displacement[0] < 0 || y + displacement[1] < 0){
				continue;
			}
			if (x + displacement[0] < n && y + displacement[1] < m && mark[y + displacement[1]][x + displacement[0]]) {
				continue;
			}
			mark[y + displacement[1]][x + displacement[0]] = true;
			way.add(displacement);
			dfs(x + displacement[0], y + displacement[1], ++step,way);
			mark[y + displacement[1]][x + displacement[0]] = false;
		}
		return;
	}

	public int getMinstep() {
		return MINSTEP;
	}

	public boolean isReach(){
		if (MINSTEP != Integer.MAX_VALUE){
			return true;
		}
		return false;
	}

	public String way(){
		if (WAY == null || WAY.size()< 1){
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int[] way : WAY){
			if (way[0] == 0 && way[1] ==1){
				stringBuilder.append("→");
			}
			if (way[0] == 1 && way[1] ==0){
				stringBuilder.append("↓");
			}
			if (way[0] == -1 && way[1] ==0){
				stringBuilder.append("←");
			}
			if (way[0] == 0 && way[1] ==-1){
				stringBuilder.append("↑");
			}
		}

		return stringBuilder.toString();
	}
}
