package com.example.algorithm.recursion;

import com.example.utils.tools.Times;

/**
 * create by Freedom on 2020/6/5
 *
 * 所有的递归都可以转成非递归
 *  自己维护一个栈，来保存参数、局部变量
 *  但是空间复杂度依然没有得到优化
 *
 *
 *  递归的使用套路
 *  ① 明确函数的功能
 *      先不要去思考里面代码怎么写，首先搞清楚这个函数的干嘛用的，能完成什么功能？
 *  ② 明确原问题与子问题的关系
 *      寻找 f(n) 与 f(n – 1) 的关系
 *  ③ 明确递归基（边界条件）
 *      递归的过程中，子问题的规模在不断减小，当小到一定程度时可以直接得出它的解
 *      寻找递归基，相当于是思考：问题规模小到什么程度可以直接得出解？
 *
 *
 *  最重要的就是f(n) 与 f(n - 1)  的关系
 */
public class Main {
    public static void main(String[] args) {
        main1(null);new Hanoi().hanoi(3, "A", "B", "C");
    }

    public static void main1(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(3));
        Fib fib = new Fib();
        int n = 44;
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib0(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib1(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib2(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib3(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib4(n)));
    }
}
