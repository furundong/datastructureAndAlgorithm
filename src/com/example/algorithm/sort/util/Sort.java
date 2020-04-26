package com.example.algorithm.sort.util;

import java.util.Arrays;

/**
 * create by Freedom on 2020/4/21
 */
public abstract class Sort implements Comparable{
    protected Integer[] array;
    private Long endTime;
    private int swapCount;
    private int cmpCount;


    public void sort(Integer[] arrays){
        if(arrays == null || arrays.length<2)
            return;
        this.array = arrays;
        long startTime = System.currentTimeMillis();
        sort();
        endTime = System.currentTimeMillis() - startTime;
    }

    protected abstract void sort();

    protected void swap(int i,int i2){
        Integer temp = array[i];
        array[i] = array[i2];
        array[i2] = temp;
        swapCount++;
    }

    protected int cmpIndex(int i, int i2){
        cmpCount++;
        return array[i] - array[i2];
    }

    protected int cmp(int i, int i2){
        cmpCount++;
        return i-i2;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "{" +
                "arrays=" + Arrays.toString(array) +
                ",\t 耗时=" + endTime +
                ",\t swapCount=" + swapCount +
                ",\t cmpCount=" + cmpCount +
                "}\n"+
                "---------------------------------------------------------------------------------------------------";
    }
}
