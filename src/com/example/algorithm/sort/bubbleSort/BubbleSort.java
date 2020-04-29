package com.example.algorithm.sort.bubbleSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/21
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmpIndex(begin - 1, begin) > 0) {
                    swap(begin - 1, begin);
                }
            }
        }
    }
}
