package com.bob.graph;

/**
 * @Author wangbo
 * @Date 2022/11/16 16:11
 * @Description: 最短路径, 通过局部最优达到全局最优 有点颓废,不想写
 * @Version 1.0
 */
public class GraphShortestPath {

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
	 * 节点数
	 */
	private int nodeCount;
	/**
	 * 邻接矩阵
	 */
	private int data[][];

	/**
	 * 地图能走的值
	 */
	private final static int[][] DISPLACEMENT_ARRAY = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public GraphShortestPath(int n, int m, int dx, int dy,int nodeCount, int[][] data) {
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
		this.nodeCount = nodeCount;
		this.data = data;
	}

	public int shortestPath(){
		int[] path = new int[nodeCount+1];
		for (int i=1; i<= path.length;i++){
			path[i] = Integer.MAX_VALUE;
		}

		return 0;
	}
	// int n, m, x; // n表示点数，m表示边数，x表示我们要的七点
	public static void seach(int x, int dis[], int value[][], int n) {
		boolean[] mark = new boolean[n+1];
		mark[x] = true;
		dis[x] = 0;
		int count = 1;
		while (count <= n) {
			// 表示新加的点
			int loc = 0;
			int min = Integer.MAX_VALUE;
			// 求dis里面的最小值 优先队列,堆logn
			for (int i = 1; i <= n; i++) {
				if (!mark[i] && dis[i] < min) {
					min = dis[i];
					loc = i;
				}
			}
			if (loc == 0){
				// 表示没有可以加的点了
				break;
			}
			mark[loc] = true;
			// 只需要关注 我们加进来的点 能有哪些路径就可以了，不用扫描所有的dis 最好的情况应该可以达到o(nlogn),最坏的情况才是O(n^2)
			for (int i = 1; i <= n; i++) {
				if (value[loc][i] != -1 && (dis[loc] + value[loc][i] < dis[i])) {
					dis[i] = dis[loc] + value[loc][i];
				}
			}
			count++;
		}
	}

}
