package com.example.algorithm.recall;

import java.util.Arrays;

/**
 * create by Freedom on 2020/6/11
 */
public class Queens {

    public static void main(String[] args) {
        new Queens().placeQueens(4);
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] cols;
    /**
     * 一共有多少种摆法
     */
    int ways;

    void placeQueens(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);  // 这个0是行号
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放皇后
     * @param row
     */
    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) { //判断是否可以存储
                // 在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);  //这句就是回缩算法的经典，外面是for，里面继续调用
                //如果出现不成立的情况，就会回来， 最外面有一个if条件，这个是做记录
                //如果成里，外面的if做个记录，就没有问题了。
            }
        }
    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            //列： 第col列已经有皇后 ，说明这一列已经放了皇后
            if (cols[i] == col) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
            //斜线： 第i行的皇后跟第row行第col列格子处在同一斜线上

            //这个就是数学公式里面的 x - x1 / (y - y1) = -1 那么就说明这两个点，是对角线
            if (row - i == Math.abs(col - cols[i])) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
        }
        System.out.println("[" + row + "][" + col + "]=true");
        return true;
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
        System.out.println("cols = " + Arrays.toString(cols));
    }
}
