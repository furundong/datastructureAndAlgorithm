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
            int insertIndex = searchInsert(source);
//            for (int i = source; i > insertIndex; i--) {
//                array[i] = array[i - 1];
//            }
            if (insertIndex < source) {
                System.arraycopy(array, insertIndex, array, insertIndex + 1, source - insertIndex);
            }
            array[insertIndex] = t;
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
