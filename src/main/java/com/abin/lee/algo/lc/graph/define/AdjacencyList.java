package com.abin.lee.algo.lc.graph.define;

import java.util.List;

/**
 * 邻接表 邻接矩阵
 * https://labuladong.online/algo/data-structure-basic/graph-basic/
 * https://labuladong.online/algo/data-structure-basic/graph-basic/#%E9%82%BB%E6%8E%A5%E8%A1%A8%E5%92%8C%E9%82%BB%E6%8E%A5%E7%9F%A9%E9%98%B5%E5%AE%9E%E7%8E%B0%E5%9B%BE%E7%BB%93%E6%9E%84
 */
public class AdjacencyList {

    //如果用代码的形式来表现，邻接表和邻接矩阵大概长这样：
    // 邻接表
// graph[x] 存储 x 的所有邻居节点
    List<Integer>[] graph;


    // 邻接矩阵
// matrix[x][y] 记录 x 是否有一条指向 y 的边
    boolean[][] matrix;



}
