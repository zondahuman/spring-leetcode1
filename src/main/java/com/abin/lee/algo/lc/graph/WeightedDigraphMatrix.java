package com.abin.lee.algo.lc.graph;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;

/**
 * // 加权有向图的通用实现（邻接矩阵）
 * 有向加权图（邻接矩阵实现）
  */
public class WeightedDigraphMatrix {

    // 存储相邻节点及边的权重
    public static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    // 邻接矩阵，matrix[from][to] 存储从节点 from 到节点 to 的边的权重
    // 0 表示没有连接
    private int[][] matrix;

    public WeightedDigraphMatrix(int n){
       matrix = new int[][];
    }

    //增，添加一条带权重的有向边，复杂度 O(1)
    public void addEdge(int from, int to, int weight){
        matrix[from][to] = weight ;
    }
    // 删，删除一条有向边，复杂度 O(V)
    public void removeEdge(int from, int to){
       matrix[from][to] = 0;
    }
    // 查，判断两个节点是否相邻，复杂度 O(V)
    public boolean hasEdge(int from, int to){
        return matrix[from][to] != 0 ;
    }

    // 查，返回一条边的权重，复杂度 O(V)
    public int weight(int from, int to){
        return matrix[from][to];
    }

    // 查，返回某个节点的所有邻居节点，复杂度 O(1)
    public List<Edge> neighbors(int from){
        List<Edge> result = new ArrayList<>();
        for (int i = 0; i <matrix[from].length ; i++) {
            if(matrix[from][i] > 0){
                result.add(new Edge(i, matrix[from][i]));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        WeightedDigraphMatrix graph = new WeightedDigraphMatrix(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
    }



}
