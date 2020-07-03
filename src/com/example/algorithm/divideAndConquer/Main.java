package com.example.algorithm.divideAndConquer;

/**
 * create by Freedom on 2020/6/11
 * ◼ 分治，也就是分而治之。它的一般步骤是
 *      ① 将原问题分解成若干个规模较小的子问题（子问题和原问题的结构一样，只是规模不一样）
 *      ② 子问题又不断分解成规模更小的子问题，直到不能再分解（直到可以轻易计算出子问题的解）
 *      ③ 利用子问题的解推导出原问题的解
 * ◼ 因此，分治策略非常适合用递归
 * ◼ 需要注意的是：子问题之间是相互独立的
 */
public class Main {
    public static void main(String[] args) {
        int i = MaxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("i = " + i);

        System.out.println(Integer.MAX_VALUE + 1);
    }
}
