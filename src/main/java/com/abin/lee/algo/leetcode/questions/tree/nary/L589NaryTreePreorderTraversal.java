package com.abin.lee.algo.leetcode.questions.tree.nary;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/
 *
 */
public class L589NaryTreePreorderTraversal {
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
     * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * @param root
     * @return
     */
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(null == root)
            return list;
        list.add(root.val);
        for (Node child:root.children){
            preorder(child);
        }
        return list;
    }

    List<Integer> resultList = new ArrayList<>();

    public List<Integer> preorder2(Node root) {
        traverse(root);
        return resultList;
    }

    public List<Integer> traverse(Node root){
        if(null == root)
            return resultList;
        resultList.add(root.val);
        for (Node child:root.children){
            traverse(child);
        }
        return resultList;
    }



}
