package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/
 * https://labuladong.online/algo/data-structure/binary-tree-part1/
 */
public class L116PopulatingNextRightPointersinEachNode {
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
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (null == root)
            return null;
        traverse(root.left, root.right);
        return root;
    }

    /**
     * 三叉树实现
     *
     * @param node1
     * @param node2
     */
    void traverse(Node node1, Node node2) {
        if (null == node1 || null == node2)
            return;
        node1.next = node2;
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);
    }


    public Node connect2(Node root) {
        if (null == root)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1)
                    node.next = queue.peek();
                if (null != node.left)
                    queue.offer(node.left);
                if (null != node.right)
                    queue.offer(node.right);
            }
        }
        return root;
    }

    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//      1
//    /  \
//   2    3
//  / \   / \
// 4   7  5   6
//      \
//       9
    public Node createTreeNode() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.right = new Node(9);

        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        return root;
    }

    @Test
    public void test() {
        Node treeNode = createTreeNode();
        Node result = connect(treeNode);
        System.out.println("result=" + JsonUtil.toJson(result));
        Node result2 = connect2(treeNode);
        System.out.println("result2=" + JsonUtil.toJson(result));
    }

}
