package com.example.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * create by Freedom on 2020/5/29
 */
public class Main {

    public static void main(String[] args) {
        Graph<Object, Double> graph = Data.directedGraph(Data.SP);
        Map<Object, Graph.PathInfo<Object, Double>> map = graph.shortestPath("A");
        ArrayList<Map.Entry<Object, Graph.PathInfo<Object, Double>>> list = new ArrayList<>(map.entrySet());
        list.forEach(System.out::println);
    }
    public static void main2(String[] args) {
        Graph<Object, Double> graph = Data.undirectedGraph(Data.SP);
        Map<Object, Graph.PathInfo<Object, Double>> map = graph.shortestPath("A");
        map.entrySet().forEach(System.out::println);
        //        doubleMap.entrySet().stream().map(e->e.getKey()+":"+e.getValue()).forEach(System.out::println);
    }

    public static void main1(String[] args) {
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
