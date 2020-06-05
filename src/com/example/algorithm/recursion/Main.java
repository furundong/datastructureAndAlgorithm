package com.example.algorithm.recursion;

import com.example.utils.tools.Times;

/**
 * create by Freedom on 2020/6/5
 */
public class Main {
    public static void main(String[] args) {
        new Hanoi().hanoi(3, "A", "B", "C");
    }

    public static void main1(String[] args) {
        Fib fib = new Fib();
        int n = 44;
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib0(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib1(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib2(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib3(n)));
        Times.test("fib", () -> System.out.println("fib1 = " + fib.fib4(n)));
    }
}
