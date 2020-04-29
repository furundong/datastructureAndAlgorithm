package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * create by Freedom on 2020/4/27
 */

public class testJava8 {

    public void test01(){
        IntStream ints = new Random(47).ints(5, 20);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("list = " + list);
        Stream<Integer> integerStream = list.stream().filter(s -> s > 4);
        Object[] objects = integerStream.toArray();
        System.out.println("objects = " + Arrays.toString(objects));
    }
}
