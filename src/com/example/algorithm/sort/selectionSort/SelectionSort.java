package com.example.algorithm.sort.selectionSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/22
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if(cmpIndex(maxIndex, begin) < 0){ //如果说是<0，那么存在一个问题。当你比较两个相同大小的值，不满足条件，如果后面有满足条件的值，那么就会出现此算法是不稳定的。
                    maxIndex = begin;
                }
            }
            swap(maxIndex, end);
        }
    }
}
