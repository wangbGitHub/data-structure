package com.bob.graph;

import com.bob.graph.bean.Point;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author wangbo
 * @Date 2022/11/14 11:09
 * @Description: 深度优先遍历-数组
 * @Version 1.0
 */
public class GraphArrayDfs {
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
	 * 地图能走的值
	 */
	private final static int[][] DISPLACEMENT_ARRAY = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public GraphArrayDfs(int n, int m, int dx, int dy, int[][] data) {
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
	 * 深度优先遍历
	 *
	 * @return true 能找到 false 不能找到
	 */
	public boolean bfs() {
		if (dx == 0 || dy == 0) {
			return true;
		}
		Queue<Point> queue = new ArrayDeque<>();
		Point point = new Point(0, 0);
		queue.add(point);
		mark[0][0] = true;
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			for (int i = 0; i < DISPLACEMENT_ARRAY.length; i++) {
				int x = poll.getX();
				int y = poll.getY();
				int[] displacement = DISPLACEMENT_ARRAY[i];
				if (x + displacement[0] >= n || y + displacement[1] >= m || x + displacement[0] < 0 || y + displacement[1] < 0) {
					continue;
				}
				if (x + displacement[0] < n && y + displacement[1] < m && mark[y + displacement[1]][x + displacement[0]]) {
					continue;
				}
				// 因为计算路径时,按照数据下标来计算的,而传输时按照下标+1开始的
				if (x + displacement[0] + 1 == dx && y + displacement[1] + 1 == dy) {
					return true;
				}
				int var = data[y + displacement[1]][x + displacement[0]];
				if (var == 0) {
					queue.add(new Point(x + displacement[0], y + displacement[1]));
				}
				mark[y + displacement[1]][x + displacement[0]] = true;
			}
		}
		return false;
	}
}
