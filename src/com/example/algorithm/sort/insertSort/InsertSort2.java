package com.example.algorithm.sort.insertSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/29
 */
public class InsertSort2<T extends Comparable<T>> extends Sort<T>{

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int current = begin;
            T t = array[begin];
            while (current>0 && cmp(t,array[current-1])<0){ //如果逆序对更多，那么进入这里多，优化就大
                array[current] = array[current-1];
                current--;
            }
            array[current] = t;
        }
    }
}
