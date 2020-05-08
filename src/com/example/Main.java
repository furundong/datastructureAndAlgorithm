package com.example;

import com.example.algorithm.sort.bubbleSort.BubbleSort;
import com.example.algorithm.sort.heapSort.HeapSort;
import com.example.algorithm.sort.insertSort.InsertSort;
import com.example.algorithm.sort.mergeSort.MergeSort;
import com.example.dataStructure.tree.heap.binaryHeap.BinaryHeap;
import com.example.dataStructure.tree.heap.binaryHeap.BinaryHeap2;
import com.example.dataStructure.tree.heap.Heap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Integer[] arrays = {12, 4, 1, 2, 41, 0, 55, 6, 2};
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(arrays);
        System.out.println("bubbleSort = " + bubbleSort);

        Integer[] array = {12, 4, 1, 2, 41, 0, 55, 6, 2};
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.sort(array);
        System.out.println("heapSort = " + heapSort);


        Integer[] arr = {12, 4, 1, 2, 41, 0, 55, 6, 2};
        InsertSort<Integer> integerInsertSort = new InsertSort<>();
        integerInsertSort.sort(arr);
        System.out.println("integerInsertSort = " + integerInsertSort);

        Integer[] arr2 = {12, 4, 1, 2, 41, 0, 55, 6, 2};
        MergeSort<Integer> mergeSort =new MergeSort<>();
        mergeSort.sort(arr2);
        System.out.println("mergeSort = " + mergeSort);

        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(7);
        heap.add(72);
        heap.add(71);
        heap.add(12);
        heap.add(22);
        heap.replace(8);

        System.out.println("heap = " + heap);
        Heap<Integer> heap2 = new BinaryHeap2<>();
        heap2.add(7);
        heap2.add(72);
        heap2.add(71);
        heap2.add(12);
        heap2.add(22);
        System.out.println("heap = " + heap2);


    }
}
