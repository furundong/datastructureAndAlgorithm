package com.example.algorithm.sort;

import com.example.algorithm.sort.quickSort.QuickSort;

/**
 * create by Freedom on 2020/5/20
 */
public class Main {

    public static void main(String[] args) {
        Integer[] arrays = {12, 4, 1, 2, 41, 0, 55, 6, 2};
        QuickSort<Integer> sort = new QuickSort<>();
        sort.sort(arrays);
        System.out.println("QuickSort = " + sort);
    }
}
