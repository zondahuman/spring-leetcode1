package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 * https://labuladong.online/algo/essential-technique/binary-tree-summary/
 * 快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后序遍历，那么我就知道你是个算法高手了。
 * 只要是递归形式的遍历，都可以有前序位置和后序位置，分别在递归之前和递归之后。
 * 所谓前序位置，就是刚进入一个节点（元素）的时候，后序位置就是即将离开一个节点（元素）的时候
 */
public class L144BinaryTreePreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    List<Integer> list = new ArrayList<>();

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    void traverse(TreeNode root) {
        if (null == root)
            return;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse3(root, list);
        return list;
    }

    void traverse3(TreeNode root, List<Integer> list){
        if(null == root)
            return;
        list.add(root.val);
        traverse3(root.left, list);
        traverse3(root.right, list);
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(null == root)
            return resultList;
        resultList.add(root.val);
        resultList.addAll(preorderTraversal2(root.left));
        resultList.addAll(preorderTraversal2(root.right));
        return resultList;
    }

    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(null == root)
            return resultList;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while(!deque.isEmpty() || null != node){
            while(null != node){
                resultList.add(node.val);
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        return resultList;
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
    public TreeNode createTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }


    @Test
    public void test() {
        TreeNode treeNode = createTreeNode();
        List<Integer> result = preorderTraversal(treeNode);
        System.out.println("result=" + result);
        List<Integer> result2 = preorderTraversal2(treeNode);
        System.out.println("result2=" + result2);
        List<Integer> result3 = preorderTraversal3(treeNode);
        System.out.println("result3=" + result3);
        List<Integer> result4 = preorderTraversal4(treeNode);
        System.out.println("result4=" + result4);
    }


}
