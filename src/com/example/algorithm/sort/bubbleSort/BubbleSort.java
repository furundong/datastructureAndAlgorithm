package com.example.algorithm.sort.bubbleSort;

import com.example.algorithm.sort.util.Sort;

/**
 * create by Freedom on 2020/4/21
 */
public class BubbleSort extends Sort {

    @Override
    protected void sort() {
        for (int end = arrays.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin - 1, begin) > 0) {
                    swap(begin - 1, begin);
                }
            }
        }
    }
}
