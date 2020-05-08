package com.example.algorithm.sort.insertSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/29
 */
public class InsertSort3<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int source = 1; source < array.length; source++) {
            T t = array[source];
            int insert = searchInsert(source);
//            for (int i = source; i > insert; i--) {
//                array[i] = array[i - 1];
//            }
            if (insert < source) {
                System.arraycopy(array, insert, array, insert + 1, source - insert);
            }
            array[source] = t;
        }
    }

    private int searchInsert(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = begin + end;
            if (cmpIndex(index, mid) > 0) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }
}
