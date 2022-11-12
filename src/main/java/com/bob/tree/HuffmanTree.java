package com.bob.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author wangbo
 * @Date 2022/11/9 15:21
 * @Description: 哈夫曼编码
 * @Version 1.0
 */
public class HuffmanTree {
	

	/**
	 * 权重映射
	 */
	private Map<String, Integer> weightMap;

	/**
	 * 编码映射
	 */
	private Map<String, String> codingMap = new HashMap<>(16);

	/**
	 * 解码映射
	 */
	private Map<String, String> decodeMap = new HashMap<>(16);

	/**
	 * 哈夫曼树
	 */
	private HuffmanNode root;

	/**
	 * 子叶节点
	 */
	private List<HuffmanNode> leafs = new ArrayList<>();

	public HuffmanTree(Map<String, Integer> weightMap) {
		if (weightMap == null) {
			throw new NullPointerException("weightMap 不能为空");
		}
		this.weightMap = weightMap;
		initHuffmanTree();
		initCodingMap();
		initDecodeMap();

	}

	/**
	 * 初始化哈夫曼树
	 */
	private void initHuffmanTree() {
		// 拿出所有的点
		String keys[] = weightMap.keySet().toArray(new String[0]);
		// jdk底层的优先队列
		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
		for (String key : keys) {
			HuffmanNode tree = new HuffmanNode();
			tree.fre = weightMap.get(key);
			tree.val = key;
			leafs.add(tree);
			priorityQueue.add(tree);
		}
		int len = priorityQueue.size();
		for (int i = 1; i < len; i++) {
			HuffmanNode left = priorityQueue.poll();
			HuffmanNode right = priorityQueue.poll();
			HuffmanNode tree = new HuffmanNode();
			tree.fre = left.fre + right.fre;
			tree.left = left;
			tree.right = right;
			left.parent = tree;
			right.parent = tree;
			priorityQueue.add(tree);
		}
		root = priorityQueue.poll();
	}

	/**
	 * 初始化编码映射关系
	 */
	private void initCodingMap() {
		for (HuffmanNode node : leafs) {
			String builder = new String();
			String key = node.val;
			do {
				if (node.parent == null) {
					break;
				}
				if (node.parent.left == node) {
					builder = "0" + builder;
				} else if (node.parent.right == node) {
					builder = "1" + builder;
				}
				node = node.parent;
			} while (node != null);
			codingMap.put(key, builder);
		}
	}

	/**
	 * 初始化解码映射关系
	 */
	private void initDecodeMap() {
		Iterator<Map.Entry<String, String>> iter = codingMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			decodeMap.put(entry.getValue(), entry.getKey());
		}
	}

	/**
	 * 解码
	 *
	 * @param source 待解码的值
	 * @return 解码后的数据
	 */
	public String decode(String source) {
		StringBuilder target = new StringBuilder();
		char[] chars = source.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (char c : chars) {
			builder.append(c);
			if (decodeMap.get(builder.toString()) != null) {
				target.append(decodeMap.get(builder.toString()));
				builder.setLength(0);
				continue;
			}
		}
		return target.toString();
	}

	/**
	 * 加密
	 *
	 * @param source 待加密的数据
	 * @return 加密后的数据
	 */
	public String encrypt(String source) {
		StringBuilder target = new StringBuilder();
		char[] chars = source.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (char c : chars) {
			builder.append(c);
			if (codingMap.get(builder.toString()) != null) {
				target.append(codingMap.get(builder.toString()));
				builder.setLength(0);
				continue;
			}
		}
		return target.toString();
	}


}
