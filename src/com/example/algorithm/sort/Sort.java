package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * create by Freedom on 2020/4/21
 */
public abstract class Sort<T extends Comparable<T>> implements Comparable<Sort<T>> {
    protected T[] array;
    private Long endTime;
    private int swapCount;
    private int cmpCount;


    public void sort(T[] arrays) {
        if (arrays == null || arrays.length < 2)
            return;
        this.array = arrays;
        long startTime = System.currentTimeMillis();
        sort();
        endTime = System.currentTimeMillis() - startTime;
    }

    protected abstract void sort();

    protected void swap(int i, int i2) {
        swapCount++;
        T temp = array[i];
        array[i] = array[i2];
        array[i2] = temp;
    }

    protected int cmpIndex(int i, int i2) {
        cmpCount++;
        return array[i].compareTo(array[i2]);
    }

    protected int cmp(T i, T i2) {
        cmpCount++;
        return i.compareTo(i2);
    }

    @Override
    public int compareTo(Sort<T> o) {
        long time = this.endTime - o.endTime;
        if (time != 0) return (int) time;
        int i = this.cmpCount - o.cmpCount;
        if (i != 0) return i;
        return this.swapCount - o.swapCount;
    }

    @Override
    public String toString() {
        return "{" +
                "arrays=" + Arrays.toString(array) +
                ",\t 耗时=" + endTime +
                ",\t swapCount=" + swapCount +
                ",\t cmpCount=" + cmpCount +
                "}\n" +
                "---------------------------------------------------------------------------------------------------";
    }
}
