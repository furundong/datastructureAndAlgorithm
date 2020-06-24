package com.example.algorithm.divideAndConquer;

/**
 * create by Freedom on 2020/6/11
 * 最大连续子序列和
 */
public class Main {
    public static void main(String[] args) {
        int i = MaxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("i = " + i);

        System.out.println(Integer.MAX_VALUE + 1);
    }
}
