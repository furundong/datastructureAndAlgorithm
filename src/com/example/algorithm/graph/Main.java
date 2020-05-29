package com.example.algorithm.graph;

import java.util.List;

/**
 * create by Freedom on 2020/5/29
 */
public class Main {
    public static void main(String[] args) {
        Object[][] objects = {
                {"a","b",2},{"a","c",3},
                {"c","b",1}
        };
        Graph<Object, Double> graph = Data.directedGraph(objects);

        graph.addEdge("aa","a",null);
//        graph.addEdge("c","a",  10d);

        graph.print();

        List<Object> objects1 = graph.topologicalSort();
        System.out.println("objects1 = " + objects1);
    }
}
