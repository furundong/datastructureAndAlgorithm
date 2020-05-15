package com.example.dataStructure.linear;

import com.example.dataStructure.linear.linked.LinkedList;

/**
 * create by Freedom on 2020/5/14
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(10);
        list.add(10);
        list.add(10);
        Integer integer = list.get(1);
        System.out.println("integer = " + integer);
        System.out.println("list = " + list);

        System.out.println(list.contains(12));
        System.out.println("\"============================================\" = " + "============================================");

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(12);
        linkedList.add(10);
        linkedList.add(10);
        linkedList.add(10);
        System.out.println("linkedList = " + linkedList);
        linkedList.set(0,1);
        System.out.println("linkedList = " + linkedList);
        
        linkedList.remove(0);
        System.out.println("linkedList = " + linkedList);
    }
}
