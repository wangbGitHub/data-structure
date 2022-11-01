package com.bob.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangbo
 * @Date 2022/11/1 15:38
 * @Description: 二叉搜索树 链表实现
 * @Version 1.0
 */
public class BinarySearchTree {

	/**
	 * 值
	 */
	private int val;

	/**
	 * 左节点
	 */
	private BinarySearchTree left;

	/**
	 * 右节点
	 */
	private BinarySearchTree right;

	/**
	 * 二叉树初始化
	 *
	 * @param val 值
	 */
	public BinarySearchTree(int val) {
		this.val = val;
		this.right = null;
		this.left = null;
	}

	/**
	 * 二叉树插入结果集
	 *
	 * @param val 值
	 */
	public void insert(BinarySearchTree tree, int val) {
		if (tree == null) {
			tree = new BinarySearchTree(val);
			return;
		}
		if (tree.val >= val) {
			if (tree.left == null) {
				BinarySearchTree node = new BinarySearchTree(val);
				tree.left = node;
				return;
			} else {
				insert(tree.left, val);
			}
		} else {
			if (tree.right == null) {
				BinarySearchTree node = new BinarySearchTree(val);
				tree.right = node;
				return;
			} else {
				insert(tree.right, val);
			}
		}
	}

	/**
	 * 中序遍历
	 *
	 * @param tree 待遍历的结果集
	 */
	public List<Integer> inTraverse(BinarySearchTree tree) {
		List<Integer> list = new ArrayList<>();
		doInTraverse(tree, list);
		return list;
	}

	/**
	 * 实际中序遍历
	 *
	 * @param tree          待遍历的树
	 * @param valueOrderlys 排好序集合
	 */
	private void doInTraverse(BinarySearchTree tree, List<Integer> valueOrderlys) {
		if (tree.left != null) {
			doInTraverse(tree.left, valueOrderlys);
		}
		valueOrderlys.add(tree.val);
		if (tree.right != null) {
			doInTraverse(tree.right, valueOrderlys);
		}
	}

	/**
	 * 删除节点
	 *
	 * @param tree 🌲
	 * @param val  待删除节点的值
	 */
	public BinarySearchTree delete(BinarySearchTree tree, int val) {
		if (tree == null) {
			return null;
		}
		if (tree.val == val){
			return replace(tree,null);
		}
		doDelete(tree, null, val);
		return tree;
	}

	private void doDelete(BinarySearchTree tree, BinarySearchTree parent, int val) {
		if (tree.val > val) {
			doDelete(tree.left, tree, val);
		}
		if (tree.val < val && tree.val != val) {
			doDelete(tree.right, tree, val);
		}
		if (tree.val == val){
			replace(tree, parent);
		}
	}

	private BinarySearchTree replace(BinarySearchTree tree, BinarySearchTree parent) {
		boolean isDoubleNode = tree.left != null && tree.right != null;
		BinarySearchTree temp = null;
		if (isDoubleNode) {
			temp = findRightMin(tree.right, tree);
		} else {
			if (tree.right != null) {
				temp = tree.right;
			}
			if (tree.left != null) {
				temp = tree.left;
			}
		}
		if (parent == null) {
			temp.left = tree.left;
			temp.right = tree.right;
			return temp;
		}
		if (parent.right != null && parent.right.val == tree.val) {
			parent.right = temp;
		}
		if (parent.left != null && parent.left.val == tree.val) {
			parent.left = temp;
		}
		return null;
	}

	private BinarySearchTree findRightMin(BinarySearchTree tree,BinarySearchTree parent) {
		if (tree.left != null){
			return findRightMin(tree.left,tree);
		}
		if (tree.right != null){
			parent.left = tree.right;
			tree.right = null;
		}
		return tree;
	}


}
