package com.bob.tree;

/**
 * @Author wangbo
 * @Date 2022/10/31 16:45
 * @Description: 链表实现二叉树
 * @Version 1.0
 */
public class LinkedTree {
	/**
	 * 值
	 */
	private String val;
	/**
	 * 左
	 */
	private LinkedTree left;
	/**
	 * 右
	 */
	private LinkedTree right;


	public LinkedTree(String val, LinkedTree left, LinkedTree right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * 前序遍历二叉树
	 * 方式:使用递归的方式实现
	 *
	 * @param tree 待遍历节点
	 */
	public void preorderRecursion(LinkedTree tree) {
		print(tree);
		if (tree.left != null) {
			preorderRecursion(tree.left);
		}
		if (tree.right != null) {
			preorderRecursion(tree.right);
		}
	}

	/**
	 * 中序遍历二叉树
	 * 方式:使用递归的方式实现
	 *
	 * @param tree 待遍历节点
	 */
	public void inRecursion(LinkedTree tree) {
		if (tree.left != null) {
			preorderRecursion(tree.left);
		}
		print(tree);
		if (tree.right != null) {
			preorderRecursion(tree.right);
		}
	}

	/**
	 * 后序遍历二叉树
	 * 方式:使用递归的方式实现
	 *
	 * @param tree 待遍历节点
	 */
	public void postorderRecursion(LinkedTree tree) {
		if (tree.left != null) {
			postorderRecursion(tree.left);
		}
		if (tree.right != null) {
			postorderRecursion(tree.right);
		}
		print(tree);
	}

	/**
	 * 前序遍历二叉树
	 * 方式:迭代
	 *
	 * @param tree 待遍历节点
	 */
	public void preorderIteration(LinkedTree tree) {
		while (tree != null){
			print(tree);


		}
	}


	/**
	 * 打印val值
	 *
	 * @param tree 待打印节点
	 */
	private void print(LinkedTree tree) {
		System.out.println(tree.val);
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public LinkedTree getLeft() {
		return left;
	}

	public void setLeft(LinkedTree left) {
		this.left = left;
	}

	public LinkedTree getRight() {
		return right;
	}

	public void setRight(LinkedTree right) {
		this.right = right;
	}
}
