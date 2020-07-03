package com.example.algorithm.recursion;

/**
 * create by Freedom on 2020/6/5
 *
 * 第一阶台阶是 1
 * 第二阶台阶是 2
 * 第三阶台阶是 3
 * 第四阶台阶是 5
 *
 * 可以看出， 从第三阶开始， 就是前两个相加得出来得， 那么也就是说 f(n) = f(n-1)+f(n-2) 
 */
public class ClimbStairs {
    int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //自行优化。  爬楼梯
}
