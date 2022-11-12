package com.bob.tree;

/**
 * @Author wangbo
 * @Date 2022/11/9 15:05
 * @Description: 哈夫曼树
 * @Version 1.0
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

	public String val;

	public int fre;

	public HuffmanNode left;

	public HuffmanNode right;

	public HuffmanNode parent;

	@Override
	public int compareTo(HuffmanNode o) {
		return this.fre - o.fre;
	}
}
