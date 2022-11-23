package com.bob.graph.bean;

/**
 * @Author wangbo
 * @Date 2022/11/14 11:14
 * @Description: 坐标
 * @Version 1.0
 */
public class Point {
	/**
	 * 坐标 x
	 */
	private int x;

	/**
	 * 坐标 y
	 */
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
