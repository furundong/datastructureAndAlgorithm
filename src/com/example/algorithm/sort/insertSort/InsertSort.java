package com.example.algorithm.sort.insertSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/4/29
 *
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 *
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 *
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T>{

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int current = begin;
            while (current>0 && cmpIndex(current,current-1)<0){
                swap(current,current-1); //这里挪动好像比交换好，就像选择比较次数比冒泡好
                current--;
            }
        }
    }
}
