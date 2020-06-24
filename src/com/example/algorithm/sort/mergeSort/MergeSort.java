package com.example.algorithm.sort.mergeSort;

import com.example.algorithm.sort.Sort;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    //创建一个中间得临时空间，大小是array得一半
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return; //只有一個元素了。此时就返回

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin; //左边数组（基于leftArray)
        int ri = mid, re = end;//右边数组（基于array）
        int ai = begin;//  array得索引
        if (le - li > 0) System.arraycopy(array, li + begin, leftArray, li, le - li);
//        for (int i = li; i < le; i++) {  //拷贝左边得数组
//            leftArray[i] = array[i + begin]; //这里得begin 是中间得元素可能存在
//        }
        while (li < le) {   //左边得元素一直有
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) { //这样得算法稳定。 右边的值小于左边的
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        }
        //如果左边结束右边没有那么，直接保持原样就可以了
    }
}
