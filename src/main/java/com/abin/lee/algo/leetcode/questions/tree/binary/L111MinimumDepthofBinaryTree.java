package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

/**
 * 111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/?show=1
 * https://labuladong.online/algo/essential-technique/binary-tree-summary/
 */
public class L111MinimumDepthofBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     *
     * @param root
     * @return
     */
    int minDepth = Integer.MAX_VALUE;
    int curDepth = 0;

    public int minDepth(TreeNode root) {
        if (null == root)
            return 0;
        traverse(root);
        return minDepth;
    }

    void traverse(TreeNode root) {
        if (null == root)
            return;
        curDepth++;
        if (root.left == null && root.right == null)
            minDepth = Math.min(curDepth, minDepth);
        traverse(root.left);
        traverse(root.right);
        curDepth--;
    }


    public int minDepth2(TreeNode root) {
        if (null == root)
            return 0;
        else if (root.right == null)
            return minDepth2(root.left) + 1;
        else if (root.left == null)
            return minDepth2(root.right) + 1;
        return 1 + Math.min(minDepth2(root.left), minDepth2(root.right));
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
        root.right.right.right = new TreeNode(6);
        return root;
    }


    @Test
    public void test() {
        TreeNode treeNode = createTreeNode();
        int result = minDepth(treeNode);
        System.out.println("result=" + result);
        int result2 = minDepth2(treeNode);
        System.out.println("result2=" + result2);
    }


}
