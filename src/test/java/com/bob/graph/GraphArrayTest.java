package com.bob.graph;

/**
 * @Author wangbo
 * @Date 2022/11/14 14:20
 * @Description: 图-数组验证
 * @Version 1.0
 */
public class GraphArrayTest {

	public static void main(String[] args) {
		int[][] ints = new int[][]{
				{0,0,1,0},
				{0,0,0,0},
				{0,0,1,0},
				{0,1,0,0},
				{0,0,0,0}
		};
		GraphArrayDfs graphArrayDfs = new GraphArrayDfs(4,5,3,4,ints);
		System.out.println(graphArrayDfs.bfs());;
		GraphArrayBfs graphArrayBfs = new GraphArrayBfs(4,5,3,4,ints);
		graphArrayBfs.dfs(0,0,0,null);
		System.out.println(graphArrayBfs.isReach());
		System.out.println(graphArrayBfs.getMinstep());
		System.out.println(graphArrayBfs.way());

	}
}
