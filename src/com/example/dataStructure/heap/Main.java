package com.example.dataStructure.heap;

import com.example.dataStructure.heap.binaryHeap.BinaryHeap2;

/**
 * create by Freedom on 2020/5/29
 */
public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new BinaryHeap2<>(null, new Integer[]{1, 23, 4, 5});

        System.out.println("heap.toString() = " + heap.toString());

    }
}
