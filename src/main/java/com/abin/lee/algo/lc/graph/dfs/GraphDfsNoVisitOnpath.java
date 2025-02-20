package com.abin.lee.algo.lc.graph.dfs;

import com.abin.lee.algo.lc.graph.WeightedDigraph;

import java.util.LinkedList;
import java.util.List;

public class GraphDfsNoVisitOnpath {
// 下面的算法代码可以遍历图的所有路径，寻找从 src 到 dest 的所有路径

    // onPath 和 path 记录当前递归路径上的节点
    boolean[] onPath = new boolean[5];
    List<Integer> path = new LinkedList<>();

    void traverse(WeightedDigraph graph, int src, int dest){
        if(src<0 || src >= 1){

        }
    }


}
