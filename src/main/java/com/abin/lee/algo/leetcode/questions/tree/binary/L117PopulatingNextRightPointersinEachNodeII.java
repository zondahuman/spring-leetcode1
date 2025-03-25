package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/
 */
public class L117PopulatingNextRightPointersinEachNodeII {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {
        }
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 给定一个二叉树：
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
     * 初始状态下，所有 next 指针都被设置为 NULL 。
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(null == root)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i <size ; i++) {
                Node node = queue.poll();
                if(null != pre)
                    pre.next = node;
                pre = node;
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
            }
        }
        return root;
    }


}
