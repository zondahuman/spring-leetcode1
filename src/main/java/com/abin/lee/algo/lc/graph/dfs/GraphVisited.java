package com.abin.lee.algo.lc.graph.dfs;

public class GraphVisited {

    static class Vertex{
        int id ;
        Vertex[] neighbors;
    }

    // 图的遍历框架
// 需要一个 visited 数组记录被遍历过的节点
// 避免走回头路陷入死循环
    void traverse(Vertex s, boolean[] visited){
        if(s == null){
            return;
        }

        if(visited[s.id]){
            // 防止死循环
            return;
        }
        visited[s.id] = true ;
        System.out.println("visit="+s.id);
        for(Vertex neighbors:s.neighbors){
            traverse(neighbors, visited);
        }
    }

}
