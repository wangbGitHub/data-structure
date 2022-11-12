package com.bob.tree;

/**
 * @Author wangbo
 * @Date 2022/11/4 16:00
 * @Description: B+树
 * @Version 1.0
 * <p>
 * 需求:
 * 1.merge 在3-9
 * 2.满足b+tree结构
 * 3.添加的值>0
 */
public class Btree {

	/**
	 * 合并节点的阀值
	 */
	private int merge;

	/**
	 * 值
	 */
	private int val;

	/**
	 * 层节点
	 */
	private Btree[] trees;

	/**
	 * 左节点
	 */
	private Btree left;

	/**
	 * 右节点
	 */
	private Btree right;

	/**
	 * 当前节点是否是最底层节点
	 */
	private boolean isBaseCourse;

	public Btree(int merge) {
		if (merge < 3 || merge > 9) {
			throw new RuntimeException("不符合规范 合并节点阀值在:0<merge<9");
		}
		this.merge = merge;
		this.left = null;
		this.right = null;
		this.isBaseCourse = true;
		this.trees = new Btree[merge];
	}

	/**
	 * 添加值
	 *
	 * @param val 添加值
	 * @return
	 */
	public boolean add(int val) {
		if (val < 1) {
			throw new RuntimeException();
		}
		if (isBaseCourse) {
			boolean isNotBlankTrees = this.isNotBlankTrees();
			add(val);
		}
		return false;
	}

	private void add(Btree parent,Btree node) {

	}


	/**
	 * 层节点 是否为空
	 * @return true 为不为空
	 */
	private boolean isNotBlankTrees() {
		if (trees == null || trees.length == 0) {
			return false;
		}
		for (Btree btree : this.trees) {
			if (btree != null) {
				return true;
			}
		}
		return false;
	}
}
