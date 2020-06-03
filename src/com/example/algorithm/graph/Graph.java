package com.example.algorithm.graph;

import java.util.*;

public abstract class Graph<V, E> {
    protected WeightManager<E> weightManager;

    public Graph(WeightManager<E> weightManager) {
        this.weightManager = weightManager;
    }

    public Graph() {
    }

    public abstract int edgesSize();

    public abstract int verticesSize();

    public abstract void addVertex(V v);

    public abstract void addEdge(V from, V to);

    public abstract void addEdge(V from, V to, E weight);

    public abstract void print();

    public abstract void bfs(V begin, VertexVisitor<V> visitor);

    public abstract void dfs(V begin, VertexVisitor<V> visitor);

    public abstract List<V> topologicalSort();

    public abstract Set<EdgeInfo<V, E>> mst();

    public abstract Map<V, E> shortestPath(V begin);

    public abstract void removeVertex(V v);

    public abstract void removeEdge(V from, V to);

    //权重管理，最小生成树是比较，最短路径是相加
    public interface WeightManager<E> {
        int compare(E w1, E w2);

        E add(E w1, E w2);

        E zero();
    }

    protected interface VertexVisitor<V> {
        boolean visit(V v);
    }

    /**
     * 边的信息
     * @param <V> 顶点信息
     * @param <E> 权值
     */
    public static class EdgeInfo<V, E> {
        protected V from;
        protected V to;
        protected E weight;
        public EdgeInfo(V from, V to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "EdgeInfo [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }
    }

    /**
     * 路径信息
     * @param <V>
     * @param <E>
     */
    public static class PathInfo<V, E> {
        protected E weight;
        protected List<EdgeInfo<V, E>> edgeInfos = new LinkedList<>();
        public PathInfo() {}
        public PathInfo(E weight) {
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "PathInfo [weight=" + weight + ", edgeInfos=" + edgeInfos + "]";
        }
    }
}
