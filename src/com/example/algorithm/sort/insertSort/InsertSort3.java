package com.example.algorithm.sort.insertSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/29
 */
public class InsertSort3<T extends Comparable<T>> extends Sort<T>{

    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            insert(i,searchInsert(i));
        }
    }
}
