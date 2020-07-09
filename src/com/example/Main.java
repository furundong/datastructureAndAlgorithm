package com.example;

import com.example.algorithm.sort.bubbleSort.BubbleSort;
import com.example.algorithm.sort.heapSort.HeapSort;
import com.example.algorithm.sort.insertSort.InsertSort;
import com.example.algorithm.sort.mergeSort.MergeSort;
import com.example.dataStructure.heap.Heap;
import com.example.dataStructure.heap.binaryHeap.BinaryHeap;
import com.example.dataStructure.heap.binaryHeap.BinaryHeap2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Main {

    public static void main1(String[] args) {
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

    public static void main(String[] args) throws Exception {
        String pathname = "C:\\Users\\Administrator\\AppData\\Local\\Temp\\baiduyunguanjia\\onlinedit\\cache";
        File file = new File(pathname);
        File[] files = file.listFiles();
        for (File file1 : files) {
            File file2 = file1.listFiles()[0];
            FileInputStream fis = new FileInputStream(file2.getCanonicalPath());
            String s = "E:\\studyOnline\\";
            FileOutputStream fos = new FileOutputStream(s +file2.getName());
            byte[] datas = new byte[1024*8];//创建搬运工具
            int len = 0;//创建长度
            while((len = fis.read(datas))!=-1)//循环读取数据
            {
                fos.write(datas,0,len);
            }
        }
    }

    public static void main2(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("1", 8);
        map.put("2", 12);
        map.put("3", 53);
        map.put("4", 33);
        map.put("5", 11);
        map.put("6", 3);
        map.put("7", 3);
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
    }
}
