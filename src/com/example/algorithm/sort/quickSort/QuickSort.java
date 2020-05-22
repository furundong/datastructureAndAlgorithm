package com.example.algorithm.sort.quickSort;

import com.example.algorithm.sort.Sort;

/**
 * create by Freedom on 2020/5/20
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }

        int meddle = pivotIndex2(begin, end);
        sort(begin, meddle);
        sort(meddle + 1, end);
    }

    private int pivotIndex2(int begin, int end) {
        E pivot = array[begin];
        end--;

        boolean flag = false;
        while (begin < end) {
            if (!flag) {
                if (cmp(pivot, array[end]) < 0) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    array[begin++] = array[end];
                    flag = true;
                }
            }
            //如果这个flag为true ，接着往下走，此时的begin跟end是已经改变的值，那么这个左边元素跟轴点元素就发生了改变
            if (flag && begin <end) {
                if (cmp(pivot, array[begin]) > 0) { // 左边元素 < 轴点元素
                    begin++;
                } else { // 左边元素 >= 轴点元素
                    array[end--] = array[begin];
                    flag = false;
                }
            }
        }

        array[begin] = pivot;
        return begin;
    }


    private int pivotIndex(int begin, int end) {
        swap(begin, begin + (int)(Math.random() * (end - begin)));

        E pivot = array[begin];
        end--;

        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) { // 左边元素 < 轴点元素
                    begin++;
                } else { // 左边元素 >= 轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        array[begin] = pivot;
        return begin;
    }


}
