package com.example.algorithm.sort.util;

import java.util.Arrays;

/**
 * create by Freedom on 2020/4/21
 */
public abstract class Sort {
    protected Integer[] arrays ;
    private Long endTime;
    private int swapCount;
    private int cmpCount;


    public void sort(Integer[] arrays){
        if(arrays == null || arrays.length<2)
            return;
        this.arrays = arrays;
        long startTime = System.currentTimeMillis();
        sort();
        endTime = System.currentTimeMillis() - startTime;
    }

    protected abstract void sort();

    protected void swap(int i,int i2){
        Integer temp = arrays[i];
        arrays[i] = arrays[i2];
        arrays[i2] = temp;
        swapCount++;
    }

    protected int cmp(int i,int i2){
        cmpCount++;
        return arrays[i] - arrays[i2];
    }

    @Override
    public String toString() {
        return "Sort{" +
                "arrays=" + Arrays.toString(arrays) +
                ", 耗时=" + endTime +
                ", swapCount=" + swapCount +
                ", cmpCount=" + cmpCount +
                '}';
    }
}
