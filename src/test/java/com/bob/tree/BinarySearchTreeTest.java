package com.bob.tree;

import java.util.List;

/**
 * @Author wangbo
 * @Date 2022/11/1 20:35
 * @Description:  二叉搜索树 链表实现
 * @Version 1.0
 */
public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(10);
		tree.insert(tree,5);
		tree.insert(tree,15);
		tree.insert(tree,3);
		tree.insert(tree,8);
		tree.insert(tree,2);
		tree.insert(tree,2);
		tree.insert(tree,1);
		tree.insert(tree,4);
		tree.insert(tree,7);
		tree.insert(tree,9);
		tree.insert(tree,13);
		tree.insert(tree,12);
		tree.insert(tree,14);
		tree.insert(tree,17);
		tree.insert(tree,16);
		tree.insert(tree,18);
		List<Integer> list = tree.inTraverse(tree);
		System.out.println(list);
		tree =tree.delete(tree,12);
		list = tree.inTraverse(tree);
		System.out.println(list);
		tree =tree.delete(tree,2);
		list = tree.inTraverse(tree);
		System.out.println(list);
		tree = tree.delete(tree,10);
		list = tree.inTraverse(tree);
		System.out.println(list);


	}
}
