package com.example.dataStructure.linear.exercise;

import com.example.dataStructure.linear.circle.SingleCircleLinkedList;

/**
 * create by Freedom on 2020/5/15
 */
public class _2_环形链表 {

    public static void main(String[] args) {
        SingleCircleLinkedList<Integer> list = new SingleCircleLinkedList<>();
        list.add(10);
        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println("list = " + list);
        boolean b = list.hasCycle();
        System.out.println(b);
    }

}
