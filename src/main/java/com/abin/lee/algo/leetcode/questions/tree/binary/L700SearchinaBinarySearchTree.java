package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
 * https://labuladong.online/algo/data-structure/bst-part2/
 */
public class L700SearchinaBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(null == root)
            return null;
        if(root.val == val)
            return root;
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return left !=null ? left : right;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if(null == root)
            return null;
        if(root.val > val)
            return searchBST(root.left, val);
        if(root.val < val)
            return searchBST(root.right, val);
        return root;
    }



}
