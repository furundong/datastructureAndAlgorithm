package com.example.algorithm.sort.bubbleSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/21
 */
public class BubbleSort3<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sort = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmpIndex(begin - 1, begin) > 0) {
                    sort = begin; //如果说进入了这里面，那么，就说明在最远距离，还是需要排序的，如果说不进入，那么就说明后面的都是排好序的
                    swap(begin - 1, begin);
                }
            }
            end = sort; // 这个最后记录排序好的那个位置。就是end的下一次开始的位置。
        }
    }
}
