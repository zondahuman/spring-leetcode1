package com.abin.lee.algo.lc.graph;

import java.util.List;

public class DirectGraphNode {

    /**
     * 有向加权图怎么实现？很简单呀
     * 如果是邻接表，我们不仅仅存储某个节点 x 的所有邻居节点，还存储 x 到每个邻居的权重，不就实现加权有向图了吗？
     *
     * 如果是邻接矩阵，matrix[x][y] 不再是布尔值，而是一个 int 值，0 表示没有连接，其他值表示权重，不就变成加权有向图了吗？
     */
// 邻接表
// graph[x] 存储 x 的所有邻居节点以及对应的权重
// 具体实现不一定非得这样，可以参考后面的通用实现
    class Edge {
        int to;
        int weight;
    }
    List<Edge>[] graph;

    // 邻接矩阵
// matrix[x][y] 记录 x 指向 y 的边的权重，0 表示不相邻
    int[][] matrix;


}
