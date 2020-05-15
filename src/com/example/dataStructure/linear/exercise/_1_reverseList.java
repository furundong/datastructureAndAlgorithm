package com.example.dataStructure.linear.exercise;

import com.example.dataStructure.linear.linked.SingleLinkedList;

/**
 * create by Freedom on 2020/5/15
 */
public class _1_reverseList {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        System.out.println("list = " + list);

        list.reverseList();
        System.out.println("list = " + list);

    }

}
