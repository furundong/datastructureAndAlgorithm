package com.example.algorithm.sort.heapSort;

import com.example.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * create by Freedom on 2020/4/22
 * 堆排序可以认为是对选择排序的一种优化。
 * <p>
 * 执行步骤：
 * 对序列进行原地建堆。
 * 交换堆顶与尾元素。
 * 堆的元素数量减1。
 * 对0位置进行1此siftDown操作。
 * <p>
 * 重复执行1-3操作，直到堆的元素数量为1。
 * <p>
 * 最好，最坏，平均时间复杂度：O(nlogn)。
 * 空间复杂度O(1)，属于不稳定排序。
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    private int heapSize;

    @Override
    protected void sort() {
        // 原地建堆，下滤
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) { //具体看堆的数据结构
            siftDown(i);
        }

        System.out.println("this.array = " + Arrays.toString(this.array));
        //自下而上的下滤

        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            swap(0, --heapSize);

            // 对0位置进行siftDown（恢复堆的性质）
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        T element = array[index];

        int half = heapSize >> 1; //非叶子节点的个数
        while (index < half) { // index必须是非叶子节点
            // 默认是左边跟父节点比
            int childIndex = (index << 1) + 1; //左子节点
            T child = array[childIndex];

            int rightIndex = childIndex + 1; //右子节点
            // 右子节点比左子节点大
            if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            // 大于等于子节点
            if (cmp(element, child) >= 0) break;

            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }
}
