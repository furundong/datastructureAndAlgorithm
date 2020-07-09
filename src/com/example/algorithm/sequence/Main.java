package com.example.algorithm.sequence;

import com.example.utils.tools.Asserts;

/**
 * create by Freedom on 2020/7/8
 */
public class Main {
    public static void main(String[] args) {
       Asserts.test(BruteForce.indexOf1("hello world", "or") == 7);
       Asserts.test(BruteForce.indexOf1("hello world", "h") == 0);
       Asserts.test(BruteForce.indexOf1("hello world", "ld") == 9);
       Asserts.test(BruteForce.indexOf1("hello world", "ld1") == -1);



        Asserts.test(BruteForce.indexOf2("hello world", "or") == 7);
        Asserts.test(BruteForce.indexOf2("hello world", "h") == 0);
        Asserts.test(BruteForce.indexOf2("hello world", "ld") == 9);
        Asserts.test(BruteForce.indexOf2("hello world", "ld1") == -1);


        Asserts.test(BruteForce.indexOf3("hello world", "or") == 7);
        Asserts.test(BruteForce.indexOf3("hello world", "h") == 0);
        Asserts.test(BruteForce.indexOf3("hello world", "ld") == 9);
        Asserts.test(BruteForce.indexOf3("hello world", "ld1") == -1);
    }
}
