package com.bob.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangbo
 * @Date 2022/11/9 17:21
 * @Description: 哈夫曼编码测试类
 * @Version 1.0
 */
public class HuffmanTreeTest {
	public static void main(String[] args) {
		Map<String, Integer> weights = new HashMap<>();
		weights.put("a", 3);
		weights.put("b", 2);
		weights.put("c", 6);
		weights.put("d", 1);
		weights.put("e", 34);
		weights.put("f", 4);
		weights.put("g", 12);

		HuffmanTree huffmenTree = new HuffmanTree(weights);
		String source = "acbbbbddgeeffgg";
		String encrypt = huffmenTree.encrypt(source);
		System.out.println(encrypt);
		System.out.println(huffmenTree.decode(encrypt));
	}
}
