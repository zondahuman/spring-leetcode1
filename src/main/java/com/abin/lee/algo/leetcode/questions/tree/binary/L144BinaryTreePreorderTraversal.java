package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

import java.util.ArrayList;
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
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    void traverse(TreeNode root){
        if(null == root)
            return;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        return list;
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
    public L104MaximumDepthofBinaryTree.TreeNode createTreeNode() {
        L104MaximumDepthofBinaryTree.TreeNode root = new L104MaximumDepthofBinaryTree.TreeNode(1);
        root.left = new L104MaximumDepthofBinaryTree.TreeNode(2);
        root.left.left = new L104MaximumDepthofBinaryTree.TreeNode(4);
        root.left.right = new L104MaximumDepthofBinaryTree.TreeNode(7);
        root.left.right.right = new L104MaximumDepthofBinaryTree.TreeNode(9);

        root.right = new L104MaximumDepthofBinaryTree.TreeNode(3);
        root.right.left = new L104MaximumDepthofBinaryTree.TreeNode(5);
        root.right.right = new L104MaximumDepthofBinaryTree.TreeNode(6);
        return root;
    }


    @Test
    public void test() {
        L104MaximumDepthofBinaryTree.TreeNode treeNode = createTreeNode();
        int result = maxDepth(treeNode);
        System.out.println("result=" + result);
        int result2 = maxDepth2(treeNode);
        System.out.println("result2=" + result2);
    }


}
