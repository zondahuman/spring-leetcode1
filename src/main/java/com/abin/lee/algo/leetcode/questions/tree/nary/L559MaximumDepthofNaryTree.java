package com.abin.lee.algo.leetcode.questions.tree.nary;

import java.util.List;

public class L559MaximumDepthofNaryTree {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;
        public Node() {
        }
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 给定一个 N 叉树，找到其最大深度。
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(null == root)
            return 0;
        int subTreeMaxDepth = 0;
        for (Node child:root.children){
            subTreeMaxDepth = Math.max(subTreeMaxDepth, maxDepth(child));
        }
        return 1 + subTreeMaxDepth;
    }


    int result = 0;
    int depth = 0;
    public int maxDepth2(Node root) {
        traverse(root);
        return result;
    }

    void traverse(Node root){
        if(null == root)
            return;
        depth++;
        result = Math.max(result, depth);
        for (Node child:root.children){
            traverse(child);
        }
        depth--;
    }



}
