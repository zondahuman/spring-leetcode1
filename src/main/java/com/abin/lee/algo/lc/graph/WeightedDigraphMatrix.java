package com.abin.lee.algo.lc.graph;

import java.util.ArrayList;
import java.util.List;

// 有向加权图（邻接矩阵实现）
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
    // 邻接表，graph[v] 存储节点 v 的所有邻居节点及对应权重
    private List<Edge>[] graph ;

    public WeightedDigraphMatrix(int n){
        // 我们这里简单起见，建图时要传入节点总数，这其实可以优化
        // 比如把 graph 设置为 Map<Integer, List<Edge>>，就可以动态添加新节点了
        graph = new List[n];
        for (int i = 0; i <n ; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    // 增，添加一条带权重的有向边，复杂度 O(1)
    public void addEdge(int from, int to, int weight){
        graph[from].add(new Edge(to, weight));
    }
    // 删，删除一条有向边，复杂度 O(V)
    public void removeEdge(int from, int to){
        for (int i = 0; i <graph[from].size() ; i++) {
            if(graph[from].get(i).to == to){
                graph[from].remove(i);
                break;
            }
        }
    }
    // 查，判断两个节点是否相邻，复杂度 O(V)
    public boolean hasEdge(int from, int to){
        for(Edge edge:graph[from]){
            if(edge.to == to){
                return true;
            }
        }
        return false;
    }

    // 查，返回一条边的权重，复杂度 O(V)
    public int weight(int from, int to){
        for(Edge edge:graph[from]){
            if(edge.to == to){
                return edge.weight;
            }
        }
        throw new IllegalArgumentException("No such edge");
    }

    // 查，返回某个节点的所有邻居节点，复杂度 O(1)
    public List<Edge> neighbors(int from){
        return graph[from];
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
