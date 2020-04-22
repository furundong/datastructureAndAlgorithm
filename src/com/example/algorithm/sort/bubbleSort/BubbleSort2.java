package com.example.algorithm.sort.bubbleSort;

import com.example.algorithm.sort.util.Sort;

/**
 * create by Freedom on 2020/4/21
 */
public class BubbleSort2 extends Sort {

    @Override
    protected void sort() {
        for (int end = arrays.length - 1; end > 0; end--) {
            boolean flag = false;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin - 1, begin) > 0) {
                    flag = true; //不能进这里面，说明整个数组都是有序的。那么直接推出就好了 。
                    swap(begin - 1, begin);
                }
            }
            if(flag) break;
        }
    }
}