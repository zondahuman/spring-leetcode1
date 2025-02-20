package com.abin.lee.algo.lc.graph;

import java.util.List;

/**
 * 邻接矩阵适用于图的边较多的情况，邻接表适用于图较为稀疏的情况。
 */
public class UnDirectWeightedDigraph {
    private WeightedDigraphTable graph ;

    public UnDirectWeightedDigraph(int n){
        graph = new WeightedDigraphTable(n);
    }

    // 增，添加一条带权重的无向边
    public void addEdge(int from, int to, int weight){
        graph.addEdge(from, to, weight);
        graph.addEdge(to, from, weight);
    }

    // 删，删除一条无向边
    public void removeEdge(int from, int to){
        graph.removeEdge(from, to);
        graph.removeEdge(to, from);
    }

    // 查，判断两个节点是否相邻
    public boolean hasEdge(int from, int to) {
        return graph.hasEdge(from, to);
    }

    // 查，返回一条边的权重
    public int weight(int from, int to) {
        return graph.weight(from, to);
    }

    // 查，返回某个节点的所有邻居节点
    public List<WeightedDigraphTable.Edge> neighbors(int v) {
        return graph.neighbors(v);
    }



    public static void main(String[] args) {
        WeightedDigraphTable graph = new WeightedDigraphTable(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // true

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " <-> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 <-> 0, wight: 3
        // 2 <-> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
        System.out.println(graph.hasEdge(1, 0)); // false
    }

}
