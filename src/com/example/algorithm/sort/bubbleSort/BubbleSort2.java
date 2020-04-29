package com.example.algorithm.sort.bubbleSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/21
 */
public class BubbleSort2<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            boolean flag = false;
            for (int begin = 1; begin <= end; begin++) {
                if (cmpIndex(begin - 1, begin) > 0) {
                    flag = true; //不能进这里面，说明整个数组都是有序的。那么直接推出就好了 。
                    swap(begin - 1, begin);
                }
            }
            if(flag) break;
        }
    }
}
