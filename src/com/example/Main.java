package com.example;

import com.example.algorithm.sort.bubbleSort.BubbleSort;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Integer[] arrays = {12, 4, 1, 2, 41, 0, 55, 6, 2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arrays);
        System.out.println("bubbleSort = " + bubbleSort);
    }
}
