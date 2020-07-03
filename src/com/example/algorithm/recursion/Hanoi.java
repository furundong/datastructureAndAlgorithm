package com.example.algorithm.recursion;

/**
 * create by Freedom on 2020/6/5
 */
public class Hanoi {

/*
◼ 其实分 2 种情况讨论即可
当 n == 1时，直接将盘子从 A 移动到 C
当 n > 1时，可以拆分成3大步骤
    ① 将 n – 1 个盘子从 A 移动到 B
    ② 将编号为 n 的盘子从 A 移动到 C
    ③ 将 n – 1 个盘子从 B 移动到 C
✓ 步骤 ① ③ 明显是个递归调用

这个就是他的步骤，那么我们将这个步骤写成代码就完成了汉诺塔
 */

    /**
     * 将第n个盘子，从p1放入p3，
     *
     * @param n  盘子
     * @param p1 柱子p1
     * @param p2 柱子p2
     * @param p3 柱子p3
     */
    void hanoi(int n, String p1, String p2, String p3) {
        if (n == 1) {
            move(n, p1, p3);
            return;
        }
        hanoi(n - 1, p1, p3, p2);
        move(n, p1, p3);
        hanoi(n - 1, p2, p1, p3);
    }

    /*
     * 移动
     */
    private void move(int n, String p1, String p3) {
        System.out.println("将第" + n + "个盘子，从" + p1 + "移动到" + p3);
    }
}
