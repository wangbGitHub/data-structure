package com.bob.hash;

import java.util.Random;

/**
 * @Author wangbo
 * @Date 2022/11/23 11:35
 * @Description: TODO
 * @Version 1.0
 */
public class BitMaptest {

	public static void main(String[] args) {
		Random random = new Random();
		BitMap bitMap = new BitMap(1000);
		int[]  array = new int[1000];
		int[]  arrayDel = new int[50];
		for (int i=1; i< 1000;i++){
			int anInt = random.nextInt(1000);
			array[i] = anInt;
			bitMap.add(anInt);
		}
		for (int i=1; i< 50;i++){
			int anInt = random.nextInt(1000);
			arrayDel[i] = anInt;
			bitMap.delete(anInt);
		}
		print(array);
		print(arrayDel);

		for (int i=1; i< 100;i++){
			int anInt = random.nextInt(1000);
			boolean exist = bitMap.exist(anInt);
			System.out.println(anInt +": "+ exist);
		}


	}

	private static void print(int[] array){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (int i : array){
			stringBuilder.append(i).append(",");
		}
		stringBuilder.append("]");
		System.out.println(stringBuilder.toString());
	}
}
