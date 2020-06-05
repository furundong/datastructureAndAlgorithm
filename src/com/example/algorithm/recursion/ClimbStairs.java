package com.example.algorithm.recursion;

/**
 * create by Freedom on 2020/6/5
 */
public class ClimbStairs {
    int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //自行优化。  爬楼梯
}
