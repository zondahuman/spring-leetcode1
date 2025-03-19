package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

import java.util.List;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 * https://labuladong.online/algo/essential-technique/binary-tree-summary/
 */
public class L543DiameterofBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * 两节点之间路径的 长度 由它们之间边数表示。
     * 示例 1：
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
     * 示例 2：
     *
     * 输入：root = [1,2]
     * 输出：1
     * @param root
     * @return
     */
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    public void traverse(TreeNode root){
        if(null == root)
            return;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int myDiameter = left + right;
        maxDiameter = Math.max(maxDiameter, myDiameter);
        traverse(root.left);
        traverse(root.right);
    }

    public int maxDepth(TreeNode root){
        if(null == root)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left , right) ;
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
        Integer result = diameterOfBinaryTree(treeNode);
        System.out.println("result=" + result);
    }





}
