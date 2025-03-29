package com.abin.lee.algo.leetcode.questions.tree.nary;

import java.util.*;

/**
 * 590. N 叉树的后序遍历
 * https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/
 */
public class L590NaryTreePostorderTraversal {
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
     * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
     *
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        traverse(root, resultList);
        return resultList;
    }
    void traverse(Node root, List<Integer> resultList){
        if(null == root)
            return;
        for (Node child:root.children)
            traverse(child, resultList);
        resultList.add(root.val);
    }


    public List<Integer> postorder2(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if(null == root)
            return resultList;
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        while(!deque.isEmpty()){
            Node node = deque.pop();
            resultList.add(node.val);
            for (Node child:node.children)
                deque.push(child);
        }
        Collections.reverse(resultList);
        return resultList;
    }




}
